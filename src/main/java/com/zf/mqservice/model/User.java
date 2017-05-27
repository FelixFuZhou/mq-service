package com.zf.mqservice.model;

import java.io.Serializable;

/**
 * 作者  zhoufu
 * 日期  2017/5/26.
 */
public class User implements Serializable {

    private String name ;
    private String loginName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
