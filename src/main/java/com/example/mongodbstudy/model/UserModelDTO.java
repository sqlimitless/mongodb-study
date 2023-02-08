package com.example.mongodbstudy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModelDTO {
    private String id;
    private String name;
    private String nick;
    private int age;
    private Gender gender;

    public UserModel toEntity(){
        return UserModel.builder()
                .name(name)
                .nick(nick)
                .age(age)
                .gender(gender)
                .build();
    }
}
