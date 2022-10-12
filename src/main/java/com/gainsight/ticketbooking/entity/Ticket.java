package com.gainsight.ticketbooking.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "Tickets")
public class Ticket {
    @Indexed(unique = true)
    private int ticketNo;
    private Status status;
    private LocalDateTime time;

    public Ticket(int ticketNo, Status status, LocalDateTime time) {
        this.ticketNo = ticketNo;
        this.status = status;
        this.time = time;
    }

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

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNo=" + ticketNo +
                ", status=" + status +
                ", localDateTime=" + time +
                '}';
    }
}
