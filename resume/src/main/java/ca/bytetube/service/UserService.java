package ca.bytetube.service;

import ca.bytetube.bean.User;
import ca.bytetube.bean.result.UserPageResult;

public interface UserService extends BaseService<User, UserPageResult> {
    User find(User user);
}
