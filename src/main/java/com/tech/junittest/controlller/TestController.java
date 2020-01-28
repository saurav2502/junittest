package com.tech.junittest.controlller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private UserServiceImpl userInterface;

    public TestController(UserServiceImpl userInterface) {
        this.userInterface = userInterface;
    }

    public TestController() {

    }

    @GetMapping("/hello")
    public String hello() {
        String s = "heelo";
        if (s != null) {
            if (!s.equals("helllo")) {

            }
        }
        return "Hello World!";
    }

    @PostMapping("/serialize/user")
    public String post(@RequestBody User user) {
        userInterface.save(user);
        return "User data saved successfully";
    }

    @GetMapping("/serialize/alluser")
    public List<User> getUsers(){
        return userInterface.getUsers();
    }
}
