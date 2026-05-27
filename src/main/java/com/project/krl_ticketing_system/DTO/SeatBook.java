package com.project.krl_ticketing_system.DTO;

import lombok.Data;

@Data
public class SeatBook {

    private char rowNum;

    private int seatNum;

    private boolean found=false;
}
