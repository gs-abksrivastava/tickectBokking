package com.gainsight.ticketbooking.controller;

import com.gainsight.ticketbooking.dto.TicketDto;
import com.gainsight.ticketbooking.entity.Response;
import com.gainsight.ticketbooking.entity.Ticket;
import com.gainsight.ticketbooking.service.BookingService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;
    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("tickets")
    public List<TicketDto> getAllTickets(){
        log.debug("At getAllTickets Controller");
        return bookingService.getTickets();
    }

    @PostMapping("ticket")
    public ResponseEntity<Response> bookTicket(@RequestBody Ticket ticket){
        log.debug("At bookTicket Controller");
        return bookingService.bookTicket(ticket);
    }
}
