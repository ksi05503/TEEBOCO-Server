package com.teeboco.demo.controller;


import com.teeboco.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserService userService;
    //Autowired? final? 왜 final을 추천하는걸까

    UserController(UserService userService){
        this.userService = userService;
    }
}
