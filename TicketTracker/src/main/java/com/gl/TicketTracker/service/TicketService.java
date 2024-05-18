package com.gl.TicketTracker.service;

import java.util.List;

import com.gl.TicketTracker.dto.TicketDto;
import com.gl.TicketTracker.entity.Ticket;

public interface TicketService {

	List<TicketDto>findAllTickets();
	
	void saveTicket(Ticket ticket);
	
	void deleteTicket(Long id);
	
	Ticket getTicketById(Long id);
	
}
