package com.example.demo.domain;

/**
 * @ClassName User
 * @Description 用户信息
 * @Author lixingxing
 * @Date 2020/8/8 11:32
 * @Version 1.0
 */
public class User {

    /**
     * 用户Id
     */
    private int id;

    /**
     * 用户名称
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
