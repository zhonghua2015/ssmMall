package com.mall.common;

/**
 * Created by eid on 2017/12/2.
 */
public class Const {
    public static final String CURRENT_USER = "currentUser";
    public static final String  EMAIL = "email";
    public static final String USERNAME = "username";
    public interface Role{
        int ROLE_CUSTOMER = 0; //normal
        int ROLE_ADMIN = 1; // admin
    }
}
