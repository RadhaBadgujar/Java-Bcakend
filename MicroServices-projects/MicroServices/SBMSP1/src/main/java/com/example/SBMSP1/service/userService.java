package com.example.SBMSP1.service;

import com.example.SBMSP1.UserInfo;
import com.example.SBMSP1.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userRepo userRepo;

    public String createUser(UserInfo userInfo) {
        userRepo.save(userInfo);
        System.out.println("In service");
        return "User Created Successfully";
    }

    public String findByUseremailId(String emailId) {
        UserInfo user = userRepo.findByEmailId(emailId);
        if (user != null) {
            return "User Found: " + user.getFullname() + user.getEmailId() + user.getPassword();
        } else {
            return "User Not Found";
        }
    }
}
