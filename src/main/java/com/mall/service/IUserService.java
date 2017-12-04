package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.pojo.User;

/**
 * Created by eid on 2017/12/2.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str, String type);
    ServerResponse<String> forgetGetQuestion(String username);
    ServerResponse<String> forgetCheckAnswer(String username, String question, String answer);
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getInformation(Integer userId);
    ServerResponse checkAdminRole(User user);
}
