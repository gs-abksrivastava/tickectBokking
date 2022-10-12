package com.gainsight.ticketbooking.service;

import com.gainsight.ticketbooking.dto.TicketDto;
import com.gainsight.ticketbooking.entity.Ticket;
import com.gainsight.ticketbooking.repository.TicketRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Ticket bookTicket(Ticket ticket){
        ticket.setTime(LocalDateTime.now());
        log.debug("At bookTicket Service");
        log.info("Adding the record to database");
        return repo.save(ticket);
    }

}
