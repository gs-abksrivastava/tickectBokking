package com.gainsight.ticketbooking.dto;

import com.gainsight.ticketbooking.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TicketDto {

    private int ticketNo;
    private Status status;
    private LocalDateTime bookingTime;



}
