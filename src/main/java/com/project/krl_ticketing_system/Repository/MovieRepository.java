package com.project.krl_ticketing_system.Repository;

import com.project.krl_ticketing_system.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
