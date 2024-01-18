package ca.bytetube.dao.impl;

import ca.bytetube.bean.User;
import ca.bytetube.bean.result.UserPageResult;
import ca.bytetube.dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class UserDaoImpl extends BaseDaoImpl<User, UserPageResult>
        implements UserDao {
    @Override
    public User find(User user) {
        try {
            String sql = "SELECT * FROM user WHERE email = ? and password = ?";
            return tpl.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    user.getEmail(), user.getPassword());
        } catch (DataAccessException e) {
            return null;
        }
    }
}
