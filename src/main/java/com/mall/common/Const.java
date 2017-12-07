package com.mall.common;

import com.google.common.collect.Sets;

import java.util.Set;

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

    public interface ProductlistOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    public enum ProductStatusEnum {
        ON_SALE(1, "在线");

        private String value;
        private int code;

        ProductStatusEnum(int code, String value) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
