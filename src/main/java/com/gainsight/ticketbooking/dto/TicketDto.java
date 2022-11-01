package com.gainsight.ticketbooking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gainsight.ticketbooking.entity.Status;
import com.gainsight.ticketbooking.entity.Type;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class TicketDto implements Serializable {

    private int ticketNo;
    private Status status;
    private LocalDateTime bookingTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Type type;



}
