package ca.bytetube.beans.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Beans {
    public static boolean debug = false;

    public static <T> T convert(Map<String, ?> map, Class<T> beanCls) {
        if (map == null || beanCls == null) return null;
        T bean = null;
        try {
            bean = beanCls.newInstance();
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                setProperty(bean, entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static <T> T convert(ResultSet rs, Class<T> beanCls) {
        if (rs == null || beanCls == null) return null;
        T bean = null;
        try {
            bean = beanCls.newInstance();
            ResultSetMetaData md = rs.getMetaData();
            int count = md.getColumnCount();
            for (int i = 1; i <= count; i++) {
                setProperty(bean, md.getColumnLabel(i), rs.getObject(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    private static void setProperty(Object bean, String name, Object value) {
        try {
            int dotIdx = name.indexOf(".");
            if (dotIdx > 0) {
                String field = name.substring(0, dotIdx);
                Object subBean = PropertyUtils.getProperty(bean, field);
                if (subBean == null) {
                    Class subBeanCls = PropertyUtils.getPropertyDescriptor(bean, field).getPropertyType();
                    subBean = subBeanCls.newInstance();
                    PropertyUtils.setProperty(bean, field, subBean);
                }
                String subName = name.substring(dotIdx + 1);
                setProperty(subBean, subName, value);
            } else {
                // BeanUtils.setProperty的功能比PropertyUtils.setProperty齐全
                BeanUtils.setProperty(bean, name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
