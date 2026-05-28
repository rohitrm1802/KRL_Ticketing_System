package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.User;
import com.project.krl_ticketing_system.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user)
    {
        userService.register(user);
        return ResponseEntity.ok("Registered successfully. Waiting for admin approval.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user)
    {

        String user1 = userService.login(user);
        return ResponseEntity.ok(user1);
    }

//    @PostMapping("/forgot-password")
//    public String forgot(@RequestParam String email) {
//        return userService.forgotPassword(email);
//    }
//    @PostMapping("/forgot-password")
//    public ResponseEntity<User> forgot(@RequestBody User user)
//    {
//        User user1 = userService.forgotPassword(user);
//        return ResponseEntity.ok(user1);
//    }

//    @PostMapping("/reset-password")
//    public String reset(@RequestParam String email,
//                        @RequestParam String otp,
//                        @RequestParam String newPassword) {
//        return userService.resetPassword(email, otp, newPassword);
//    }

//    @PostMapping("/reset-password")
//    public ResponseEntity<String> reset(@RequestBody User user)
//    {
//        String user1 = userService.resetPassword(user);
//        return ResponseEntity.ok(user1);
//    }

}
