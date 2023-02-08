package com.example.mongodbstudy.repository;

import com.example.mongodbstudy.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserModel, String> {
    List<UserModel> findByName(String name);
}