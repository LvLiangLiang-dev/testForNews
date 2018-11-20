package com.lll.designPattern.observer;

/**
 * Created by lvliangliang on 2018/05/24.
 */
public class User implements Observer {
    private String  name;
    private String message;
    public User(String name ) {
        this.name = name;
    }
    @Override
    public void updata(String message) {
        this.message=message;
        read();
    }
    private void read() {
        System.out.println(name+" is reading :"+message);
    }
}
