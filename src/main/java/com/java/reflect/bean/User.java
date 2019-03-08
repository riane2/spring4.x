package com.java.reflect.bean;

public class User {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this.name);
    }

    private void write(String name) {
        System.out.println("this is write method..." + name);
    }
}
