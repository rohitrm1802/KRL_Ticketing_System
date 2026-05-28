package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.User;

public interface UserService {

    public void register(User user);

    public String login(User user);

//    public String forgotPassword(String email);

    //public String resetPassword(String email, String otp, String newPassword);

//    public User forgotPassword(User user);
//
//    public String resetPassword(User user1);

}
