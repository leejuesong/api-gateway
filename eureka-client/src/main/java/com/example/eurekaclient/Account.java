package com.example.eurekaclient;

import javax.validation.constraints.NotNull;

public class Account {
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int age;

    public Account(@NotNull int id, @NotNull String name, @NotNull int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
