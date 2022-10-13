package com.gainsight.ticketbooking.service;

import com.gainsight.ticketbooking.dto.DtoUtility;
import com.gainsight.ticketbooking.dto.TicketDto;
import com.gainsight.ticketbooking.entity.Ticket;
import com.gainsight.ticketbooking.repository.TicketRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    TicketRepo ticketRepo;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DtoUtility dtoUtility;

    public List<TicketDto> getTickets(){
        log.info("Fetching all tickets from DB");
        List<Ticket> tickets = ticketRepo.findAll();
        List<TicketDto> ticketDtos = dtoUtility.convertTicketListToDtoList(tickets);
        return ticketDtos;
    }

    public boolean bookTicket(TicketDto ticketDto){
        log.info("Saving ticket info for ticketNo : {}",ticketDto.getTicketNo());
        Ticket ticket = dtoUtility.convertTicketDtoToTicket(ticketDto);
        Ticket existingTicket = ticketRepo.findByTicketNo(ticket.getTicketNo());
        boolean isTicketBooked;
        if(existingTicket != null) {
              isTicketBooked = false;
        }else {
            ticketRepo.save(ticket);
            isTicketBooked = true;
        }
        return isTicketBooked;
    }

}
