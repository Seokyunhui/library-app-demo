package com.group.libraryapp.domain;

public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s) 가 입력되었습니다. ", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
