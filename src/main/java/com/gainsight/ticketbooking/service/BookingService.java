package com.gainsight.ticketbooking.service;

import com.gainsight.ticketbooking.dto.TicketDto;

import java.util.List;


public interface BookingService {
    public boolean bookTicket(TicketDto ticketDto);
    public List<TicketDto> getTickets();
}
