package com.gainsight.ticketbooking.dto;

import com.gainsight.ticketbooking.entity.Status;

import java.time.LocalDateTime;

public class TicketDto {

    private int ticketNo;
    private Status status;
    private LocalDateTime time;

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
