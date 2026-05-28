package com.project.krl_ticketing_system.Entity;

import com.project.krl_ticketing_system.Enum.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Role role;

//    //private boolean enabled;
//    @Enumerated(EnumType.STRING)
//    private UserStatus status;

    private Boolean firstLogin;
    private LocalDateTime lastLogin;

    private String otp;
    private LocalDateTime otpExpiry;

}
