package com.gainsight.ticketbooking.controller;

import com.gainsight.ticketbooking.dto.DtoUtility;
import com.gainsight.ticketbooking.dto.TicketDto;
import com.gainsight.ticketbooking.entity.Response;
import com.gainsight.ticketbooking.entity.Ticket;
import com.gainsight.ticketbooking.service.BookingService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    DtoUtility dtoUtility;
    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("tickets")
    public List<TicketDto> getAllTickets(){
        log.info("At getAllTickets Controller");
        return bookingService.getTickets();
    }

    @PostMapping("ticket")
    public ResponseEntity<Response> bookTicket(@RequestBody TicketDto ticketDto){
        log.info("At bookTicket Controller");
        ticketDto.setBookingTime(LocalDateTime.now());
        boolean bookingCompleted = bookingService.bookTicket(ticketDto);
        Response response = new Response();
        HttpStatus creationStatus;
        boolean isTicketBooked;
        if(!bookingCompleted) {
            response.setTicketDto(ticketDto);
            response.setStatusMsg("Given ticket No. already exits, please change it");
            creationStatus = HttpStatus.BAD_REQUEST;
        }else {
            Ticket ticket = dtoUtility.convertTicketDtoToTicket(ticketDto);
            response.setTicketDto(ticketDto);
            response.setStatusMsg("Ticket Booked Successfully");
            creationStatus = HttpStatus.CREATED;
        }
        return ResponseEntity
                .status(creationStatus)
                .body(response);
    }
}
