package com.gainsight.ticketbooking.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "TicketStatus")
public class Ticket {
//    @Indexed(unique = true)

    @Id
    private int ticketNo;
    private Status status;
    private LocalDateTime bookingTime;


}
