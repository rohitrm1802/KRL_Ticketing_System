package com.project.krl_ticketing_system.Repository;

import com.project.krl_ticketing_system.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository  extends JpaRepository<Theater,Long> {

}
