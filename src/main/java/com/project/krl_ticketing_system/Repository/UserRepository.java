package com.project.krl_ticketing_system.Repository;

import com.project.krl_ticketing_system.Enum.Role;
import com.project.krl_ticketing_system.Entity.User;
//import com.project.krl_ticketing_system.Entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>
{
    Optional<User> findByUsername(String username);

    boolean existsByRole(Role role);
    Optional<User> findByEmail(String email);

    //List<User> findByEnabled(boolean enabled);

    //List<User> findByStatus(UserStatus status);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
