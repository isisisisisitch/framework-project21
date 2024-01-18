package ca.bytetube.service.impl;

import ca.bytetube.bean.User;
import ca.bytetube.bean.result.UserPageResult;
import ca.bytetube.dao.UserDao;
import ca.bytetube.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, UserPageResult> implements UserService {
    @Override
    public User find(User user) {
        return ((UserDao) dao).find(user);
    }
}
