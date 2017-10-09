package com.yuchu.common;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 20:34  2017/9/26
 * @Modified By:
 */
public class Const {

    public static final String CURRENT_USER = "current_user";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";
    public interface Role{

        int ROLE_CUSTOMER = 0;  //普通用户
        int ROLE_ADMIN = 1; //管理员
    }
}
