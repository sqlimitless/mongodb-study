package com.example.mongodbstudy.service;

import com.example.mongodbstudy.model.UserModel;
import com.example.mongodbstudy.model.UserModelDTO;
import com.example.mongodbstudy.repository.UserRepository;
import com.mongodb.ReadPreference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("data insert")
    public void insert() {
        // given
        // when
        // then
        UserModelDTO userModelDTO = new UserModelDTO();
        userModelDTO.setName("이름~!!!");
        userModelDTO.setAge(5);
        userModelDTO.setNick("닉!!!");

        userRepository.save(userModelDTO.toEntity());
    }

    @Test
    @DisplayName("전체조회")
    public void findAll() {
        List<UserModel> all = userRepository.findAll();
    }

    @Test
    @DisplayName("Read Preference 테스트")
    public void readPreference () {
        /**
         * Read Preference를 테스트 하기위해
         * MongoDB Atlas 모니터링을 통해 Primary로 들어가는지 Secondary로 들어가는지 확인할 예정
         * */
        UserModelDTO userModelDTO = new UserModelDTO();
        userModelDTO.setName("이름");
        userModelDTO.setAge(5);
        userModelDTO.setNick("닉");
        userRepository.save(userModelDTO.toEntity());
        while (true) {
            userRepository.findByName(userModelDTO.getName());
            System.out.println(1);
        }
    }
}