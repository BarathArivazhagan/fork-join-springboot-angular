package com.barath.app.controller;

import com.barath.app.model.User;
import com.barath.app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/fromFuture")
    public List<User> fromFutureTasks(){
        return this.userService.getIndividualUserThroughFuture(10L);
    }
}
