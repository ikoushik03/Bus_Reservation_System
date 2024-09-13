package com.koushik.controller;

import com.koushik.model.User;
import com.koushik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/role")
public class AdminPanel {

    @Autowired
    private UserService userService;

    @PatchMapping("/{id}")
    public User updateField(@PathVariable int id, @RequestBody Map<String,Object> fields){
        return userService.updateField(id,fields);
    }
}
