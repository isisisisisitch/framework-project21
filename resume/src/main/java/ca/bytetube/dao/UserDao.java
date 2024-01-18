package ca.bytetube.dao;

import ca.bytetube.bean.User;
import ca.bytetube.bean.result.UserPageResult;

public interface UserDao extends BaseDao<User, UserPageResult> {
    User find(User user);
}
