package com.gl.TicketTracker.mapper;

import com.gl.TicketTracker.dto.TicketDto;
import com.gl.TicketTracker.entity.Ticket;

public class TicketMapper {

	//map Entity to Dto
	public  static TicketDto mapToTicketEntity(Ticket ticket) {
		TicketDto ticketDto= TicketDto.builder()
							 .id(ticket.getId())
							 .title(ticket.getTitle())
							 .description(ticket.getDescription())
							 .content(ticket.getContent())
							 .CreatedOn(ticket.getCreatedOn())
							 .UpdatedOn(ticket.getUpdatedOn())
							 .build();
		return ticketDto;
	}
	
	public static Ticket mapToTicketDto(TicketDto ticketDto) {
		Ticket ticket=Ticket.builder()
					  .id(ticketDto.getId())
					  .title(ticketDto.getTitle())
					  .description(ticketDto.getDescription())
					  .content(ticketDto.getContent())
					  .CreatedOn(ticketDto.getCreatedOn())
					  .UpdatedOn(ticketDto.getUpdatedOn())
					  .build();
		return ticket;
	}
}
