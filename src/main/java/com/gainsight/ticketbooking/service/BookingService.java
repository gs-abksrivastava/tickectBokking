package com.gainsight.ticketbooking.service;

import com.gainsight.ticketbooking.dto.TicketDto;
import com.gainsight.ticketbooking.entity.Response;
import com.gainsight.ticketbooking.entity.Ticket;
import com.gainsight.ticketbooking.repository.TicketRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    TicketRepo repo;
    Logger log = LoggerFactory.getLogger("SampleLogger");

    public List<TicketDto> getTickets(){
        log.debug("At getTickets Service");
        log.info("Getting all tickets from DB");
        List<Ticket> tickets = repo.findAll();
        List<TicketDto> ticketDtos = new ArrayList<>();
        log.info("Creating a list of DTOs");
        for(Ticket ticket: tickets){
            TicketDto dto = new TicketDto();
            dto.setTicketNo(ticket.getTicketNo());
            dto.setStatus(ticket.getStatus());
            dto.setTime(ticket.getTime());

            ticketDtos.add(dto);
        }

        return ticketDtos;
    }

    public ResponseEntity<Response> bookTicket(Ticket ticket){

        log.debug("At bookTicket Service");
        log.info("Adding the record to database");
        Ticket existingTicket = repo.findByTicketNo(ticket.getTicketNo());
        Response response = new Response();
        HttpStatus creationStatus;
        if(existingTicket != null) {
            response.setTicket(ticket);
            response.setStatusMsg("Given ticket No. already exits, please change it");
            creationStatus = HttpStatus.BAD_REQUEST;
        }else {
            ticket.setTime(LocalDateTime.now());
            repo.save(ticket);
            response.setTicket(ticket);
            response.setStatusMsg("Ticket Booked Successfully");
            creationStatus = HttpStatus.CREATED;
        }
        return ResponseEntity
                .status(creationStatus)
                .body(response);
    }

}
