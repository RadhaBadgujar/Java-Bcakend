package com.example.SBMSP1.Controller;

import com.example.SBMSP1.UserInfo;
import com.example.SBMSP1.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody UserInfo userInfo) {
        return userService.createUser(userInfo);
    }

    @GetMapping("/{emailId}")
    public String findByUseremailId(@PathVariable String emailId) {
        return userService.findByUseremailId(emailId);
    }
}
