package com.gainsight.ticketbooking.dto;

import com.gainsight.ticketbooking.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoUtility {

    public TicketDto convertTicketToTicketDto(Ticket ticket){
        TicketDto ticketDto = TicketDto.builder()
                .ticketNo(ticket.getTicketNo())
                .bookingTime(ticket.getBookingTime())
                .status(ticket.getStatus())
                .build();

        return ticketDto;
    }

    public Ticket convertTicketDtoToTicket(TicketDto ticketDto){
        Ticket ticket = Ticket.builder()
                .ticketNo(ticketDto.getTicketNo())
                .bookingTime(ticketDto.getBookingTime())
                .status(ticketDto.getStatus())
                .build();

        return ticket;
    }

    public List<TicketDto> convertTicketListToDtoList(List<Ticket> tickets){
        List<TicketDto> ticketDtos = new ArrayList<>();
        for(Ticket ticket :tickets){
            ticketDtos.add(convertTicketToTicketDto(ticket));
        }
        return ticketDtos;
    }

}
