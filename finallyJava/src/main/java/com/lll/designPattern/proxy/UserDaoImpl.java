package com.lll.designPattern.proxy;

/**
 * Created by lvliangliang on 2018/05/24.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("----already stored----");
    }
}
