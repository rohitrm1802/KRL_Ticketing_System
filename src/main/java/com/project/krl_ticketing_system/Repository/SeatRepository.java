package com.project.krl_ticketing_system.Repository;

import com.project.krl_ticketing_system.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
