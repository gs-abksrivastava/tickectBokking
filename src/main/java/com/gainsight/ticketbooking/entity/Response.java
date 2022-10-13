package com.gainsight.ticketbooking.entity;

import com.gainsight.ticketbooking.dto.TicketDto;
import lombok.Data;

@Data
public class Response {
    private TicketDto ticketDto;
    private String statusMsg;

}
