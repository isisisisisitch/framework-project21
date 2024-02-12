package ca.bytetube.dao.impl;

import ca.bytetube.bean.Contact;
import ca.bytetube.bean.result.ContactPageResult;
import ca.bytetube.dao.ContactDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactDaoImpl extends BaseDaoImpl<Contact, ContactPageResult> implements ContactDao {
    @Override
    protected List<Object> buildArgs(StringBuilder sql, ContactPageResult result) {
        List<Object> args = new ArrayList<>();
        sql.append(" WHERE 1 = 1 ");
        String keyword = result.getKeyword();
        if (keyword != null && keyword.length() > 0) {
            sql.append(" AND name LIKE ? OR email LIKE ? OR subject LIKE ? OR comment LIKE ? ");
            keyword = "%" + keyword + "%";
            args.add(keyword);
            args.add(keyword);
            args.add(keyword);
            args.add(keyword);
        }
        Date beginDay = result.getBeginDay();
        if (beginDay != null) {
            sql.append(" AND created_time >= ? ");
            args.add(beginDay);
        }
        Date endDay = result.getEndDay();
        if (endDay != null) {
            sql.append(" AND created_time <= ? ");
            args.add(endDay);
        }
        Integer type = result.getType();
        if (type != null && type < 2) {
            sql.append(" AND already_read = ? ");
            args.add(type);
        }
        return args;
    }
}
