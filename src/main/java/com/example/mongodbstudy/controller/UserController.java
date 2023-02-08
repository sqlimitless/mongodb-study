package com.example.mongodbstudy.controller;

import com.example.mongodbstudy.model.UserModelDTO;
import com.example.mongodbstudy.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @GetMapping(value = "/name/{name}")
    public String findUserName(@PathVariable("name") String name) {
        return userService.findUserName(name);
    }

    @PostMapping(value = "")
    public String saveUser(@RequestBody UserModelDTO userModelDTO) {
        return userService.saveUser(userModelDTO);
    }
}