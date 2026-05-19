package com.project.krl_ticketing_system.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String tname;
    public String address;
}
