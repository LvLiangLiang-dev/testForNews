package com.forbaidu.jackson;
import java.util.Date;
public class user {
    private String name;
    private Integer age;
    private Integer birthday;
    private String email;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
