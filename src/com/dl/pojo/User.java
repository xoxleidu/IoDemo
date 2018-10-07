package com.dl.pojo;

import java.io.Serializable;

/**
 * serializable 序列化标记接口
 * transient 标记序列化时候不保存此属性
 */
public class User implements Serializable {

    private String name;
    private Integer age;
    //private transient Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
