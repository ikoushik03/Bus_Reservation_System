package com.koushik.controller;

import com.koushik.dto.UserDTO;
import com.koushik.model.User;
import com.koushik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO){
        User user = userService.signup(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

}
