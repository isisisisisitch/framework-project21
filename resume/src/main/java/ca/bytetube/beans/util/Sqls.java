package ca.bytetube.beans.util;

import ca.bytetube.beans.annotation.SQLColumn;
import ca.bytetube.beans.annotation.SQLSaveIgnore;
import ca.bytetube.beans.bean.SQLBean;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Sqls {

    public static String buildFindSingleSQL(Class beanCls) {
        return buildFindSQL(beanCls, true);
    }

    public static String buildFindSQL(Class beanCls) {
        return buildFindSQL(beanCls, false);
    }

    private static String buildFindSQL(Class beanCls, boolean single) {
        if (beanCls == null) return null;
        StringBuilder sql = new StringBuilder();
        try {
            List<String> columns = new ArrayList<>();
            List<String> tables = new ArrayList<>();
            List<String> conditions = new ArrayList<>();
            buildFindSQL(beanCls, "", columns, tables, conditions, 0);
            sql.append("SELECT\n");

            for (String column : columns) {
                sql.append("\t").append(column).append(",\n");
            }
            sql.deleteCharAt(sql.length() - 2);

            sql.append("FROM\n");

            for (String table : tables) {
                sql.append("\t").append(table).append(",\n");
            }
            sql.deleteCharAt(sql.length() - 2);
            boolean hasCondition = conditions.size() > 0;
            if (hasCondition) {
                sql.append("WHERE\n\t1 = 1\n");
                for (String condition : conditions) {
                    sql.append("\tAND ").append(condition).append("\n");
                }
            }

            if (single) {
                if (hasCondition) {
                    sql.append("\tAND ");
                } else {
                    sql.append("WHERE\n\t");
                }
                String name = Strings.underlineCased(beanCls.getSimpleName());
                sql.append("`").append(name).append("`.`id` = ?");
            } else {
                sql.deleteCharAt(sql.length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Beans.debug) {
            System.out.println("【buildFindSQL】" + beanCls);
            System.out.println(sql);
            System.out.println("-------------------------------------");
        }
        return sql.toString();
    }

    private static void buildFindSQL(Class beanCls,
                                     String prefix,
                                     List<String> columns,
                                     List<String> tables,
                                     List<String> conditions,
                                     int tableIdx) {
        String alias = "t" + tableIdx;
        String name = Strings.underlineCased(beanCls.getSimpleName());
        tables.add("`" + name + "` " + alias);

        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(beanCls);
        for (PropertyDescriptor pd : pds) {
            if (pd.getWriteMethod() == null) continue;
            Class type = pd.getPropertyType();
            if (Map.class.isAssignableFrom(type)) continue;
            if (Collection.class.isAssignableFrom(type)) continue;
            Method getter = pd.getReadMethod();
            String originName = pd.getName();
            String newName = Strings.underlineCased(originName);
            SQLColumn sc = getter.getAnnotation(SQLColumn.class);
            String column = (sc != null) ? sc.value() : newName;
            if (SQLBean.class.isAssignableFrom(type)) {
                if (sc == null) {
                    column += "_id";
                }
                ++tableIdx;
                conditions.add( alias + ".`" + column + "` = t" + tableIdx + ".`id`");
                String newPrefix = prefix + pd.getName() + ".";
                buildFindSQL(type, newPrefix, columns, tables, conditions, tableIdx);
            } else {
                column = alias + ".`" + column + "` `" + prefix + originName + "`";
                columns.add(column);
            }
        }
    }

    public static String buildSaveSQL(SQLBean bean, List<Object> args) {
        if (bean == null || args == null) return null;
        StringBuilder sql = new StringBuilder();
        try {
            Class beanCls = bean.getClass();
            Integer id = bean.getId();
            String table = "`" + Strings.underlineCased(beanCls.getSimpleName()) + "`";
            PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(beanCls);
            if (id == null || id < 1) {
                sql.append("INSERT INTO\n\t");
                sql.append(table);
                sql.append("(\n");
                StringBuilder qms = new StringBuilder("VALUES\n\t(");
                for (PropertyDescriptor pd : pds) {
                    String column = getSaveColumn(bean, pd, args);
                    if (column == null) continue;
                    sql.append("\t\t`").append(column).append("`,\n");
                    qms.append("?, ");
                }
                sql.replace(sql.length() - 2, sql.length(), "\n\t)\n");
                qms.replace(qms.length() - 2, qms.length(), ")");
                sql.append(qms);
            } else {
                sql.append("UPDATE\n\t");
                sql.append(table);
                sql.append("\nSET\n");
                for (PropertyDescriptor pd : pds) {
                    String column = getSaveColumn(bean, pd, args);
                    if (column == null) continue;
                    sql.append("\t`").append(column).append("` = ?,\n");
                }
                sql.replace(sql.length() - 2, sql.length(), "\nWHERE\n\t`id` = ?");
                args.add(bean.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Beans.debug) {
            System.out.println("【buildSaveSQL】" + bean);
            System.out.println(sql);
        }
        return sql.toString();
    }

    private static String getSaveColumn(SQLBean bean, PropertyDescriptor pd, List<Object> args)
            throws Exception {
        if (pd.getWriteMethod() == null) return null;
        Class type = pd.getPropertyType();
        if (Map.class.isAssignableFrom(type)) return null;
        if (Collection.class.isAssignableFrom(type)) return null;
        Method getter = pd.getReadMethod();
        SQLSaveIgnore ssi = getter.getAnnotation(SQLSaveIgnore.class);
        if (ssi != null) return null;
        SQLColumn sc = getter.getAnnotation(SQLColumn.class);
        String column = (sc != null) ? sc.value() : Strings.underlineCased(pd.getName());
        Object value = getter.invoke(bean);
        if (value instanceof SQLBean) {
            if (sc == null) {
                column += "_id";
            }
            args.add(((SQLBean) value).getId());
        } else {
            args.add(value);
        }
        return column;
    }
}
