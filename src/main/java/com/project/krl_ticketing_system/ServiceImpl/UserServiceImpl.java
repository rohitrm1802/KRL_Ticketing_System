package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Service.UserService;
import com.project.krl_ticketing_system.Enum.Role;
import com.project.krl_ticketing_system.Entity.User;
//import com.project.krl_ticketing_system.Entity.UserStatus;
//import com.project.krl_ticketing_system.Exception.AccountNotActiveException;
//import com.project.krl_ticketing_system.Exception.InvalidOtpException;
//import com.project.krl_ticketing_system.Exception.OtpExpiredException;
//import com.project.krl_ticketing_system.Exception.UserNotFoundException;
import com.project.krl_ticketing_system.Repository.UserRepository;
import com.project.krl_ticketing_system.Security.JwtUtil;
import com.project.krl_ticketing_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtUtil jwtService;

    @Autowired
    AuthenticationManager auth;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

//    @Autowired
//    private EmailServiceImpl emailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void register(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));

        if(user.getRole() == Role.ADMIN)
        {
            user.setRole(Role.ADMIN);
        }
        if(user.getRole() == Role.USER)
        {
            user.setRole(Role.USER);
        }

        if(userRepository.existsByEmail(user.getEmail()))
        {
            throw new DataIntegrityViolationException("Email is already exists");
        }
        if(userRepository.existsByUsername(user.getUsername()))
        {
            throw new DataIntegrityViolationException("Username is already exists");
        }

//        user.setStatus(UserStatus.PENDING);

        user.setFirstLogin(false);

        user.setOtp(null);

        userRepository.save(user);
    }

    @Override
    public String login(User user) {

        Authentication authentication = auth.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

//        if (!authentication.isAuthenticated()) {
//            //return "Invalid username or password";
//        }

        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

//          if (dbUser.getStatus() != UserStatus.ACTIVE)
//          {
//              throw new AccountNotActiveException("Account Status Is Not Active, Contact Super Admin");
//          }

//        dbUser.setLastLogin(LocalDateTime.now());
        userRepository.save(dbUser);

//        if (dbUser.getFirstLogin())
//            return "Reset Your Password";

        return jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
    }

//    @Override
//    public String forgotPassword(String email) {
//
//        User user = userRepository.findByEmail(email).orElseThrow(
//                ()-> new RuntimeException("Email Not Found")
//        );
//
//        String otp = generateOtp();
//
//        user.setOtp(otp);
//        user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
//
//        userRepository.save(user);
//
//        emailService.sendOtpEmail(email, otp);
//
//        return "OTP sent to your email";
//    }

//    @Override
//    public User forgotPassword(User user1)
//    {
//        User user = userRepository.findByEmail(user1.getEmail()).orElseThrow(
//                ()-> new UserNotFoundException("Email Not Found")
//        );
//
//        String otp = generateOtp();
//
//        user.setOtp(otp);
//        user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
//
//        emailService.sendOtpEmail(user.getEmail(),otp);
//
//        return userRepository.save(user);
//    }

//    public static String generateOtp()
//    {
//        return String.valueOf(
//                100000 + new Random().nextInt(999999)
//        );
//    }

//    @Override
//    public String resetPassword(String email, String otp, String newPassword) {
//
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("Email not found"));
//
//        if (!otp.equals(user.getOtp()))
//            return "Invalid OTP";
//
//        if (user.getOtpExpiry().isBefore(LocalDateTime.now()))
//            return "OTP expired";
//
//        user.setPassword(encoder.encode(newPassword));
//        user.setFirstLogin(false);
//        user.setOtp(null);
//        user.setOtpExpiry(null);
//
//        userRepository.save(user);
//
//        return "Password updated successfully";
//    }

//    public String resetPassword(User user1)
//    {
//        User user = userRepository.findByEmail(user1.getEmail())
//                .orElseThrow(()-> new UserNotFoundException("Email Not Found"));
//
//        if (!user1.getOtp().equals(user.getOtp()))
//        {
//            throw new InvalidOtpException("Invalid OTP");
//        }
//
//        if (user.getOtpExpiry().isBefore(LocalDateTime.now()))
//        {
//            throw new OtpExpiredException("OTP expired");
//        }
//
//        user.setPassword(encoder.encode(user1.getPassword()));
//        user.setFirstLogin(false);
//        user.setOtp(null);
//        user.setOtpExpiry(null);
//
//        userRepository.save(user);
//
//        return "Password updated successfully";
//    }

}
