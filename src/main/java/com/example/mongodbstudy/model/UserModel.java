package com.example.mongodbstudy.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "user")
public class UserModel {

    @Id
    private String id;
    private String name;
    private String nick;
    private int age;
    private Gender gender;

}
