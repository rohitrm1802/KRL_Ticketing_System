package com.project.krl_ticketing_system.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String theater_name;
    public String address;
}
