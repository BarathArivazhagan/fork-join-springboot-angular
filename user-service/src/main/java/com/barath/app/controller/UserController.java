package com.barath.app.controller;


import com.barath.app.entity.User;
import com.barath.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/user",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User saveUser(@RequestBody @Valid User user){
    	
        return this.userService.saveUser(user);
    }
    
    @PostMapping(value="/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> saveUsers(@RequestBody List<User> users){
    	return this.userService.saveUsers(users);
    }


    @GetMapping(value="/user/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@PathVariable Long userId){

        return this.userService.getUser(userId);
    }

    @GetMapping(value="/user/byName/{userName}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@PathVariable String userName){

        return this.userService.getUserByUserName(userName);
    }

    @GetMapping(value="/users")
    public List<User> getUsers(){

        return this.userService.getUsers();
    }
}
