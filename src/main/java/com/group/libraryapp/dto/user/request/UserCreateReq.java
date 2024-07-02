package com.group.libraryapp.dto.user.request;

public class UserCreateReq {
    private String name;
    private Integer age; // null 표현을 위해 Integer 사용

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
