package com.example.mongodbstudy.service;

import com.example.mongodbstudy.model.UserModelDTO;
import com.example.mongodbstudy.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserService {

    private final UserRepository userRepository;

    public String findUserName(String name) {
        return objToJson(userRepository.findByName(name));
    }

    public String findAll() {
        return objToJson(userRepository.findAll());
    }

    public String saveUser(UserModelDTO userModelDTO) {
        return objToJson(userRepository.save(userModelDTO.toEntity()));
    }

    private String objToJson (Object obj){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public String findById(String id) {
        return objToJson(userRepository.findById(id));
    }
}