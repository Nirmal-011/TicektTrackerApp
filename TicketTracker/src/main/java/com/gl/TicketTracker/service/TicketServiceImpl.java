package com.gl.TicketTracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gl.TicketTracker.dto.TicketDto;
import com.gl.TicketTracker.entity.Ticket;
import com.gl.TicketTracker.mapper.TicketMapper;
import com.gl.TicketTracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository=ticketRepository;
	}
	@Override
	public List<TicketDto> findAllTickets() {
		List<Ticket>tickets=this.ticketRepository.findAll();
		return tickets.stream().map(TicketMapper :: mapToTicketEntity).collect(Collectors.toList());
	}
	@Override
	public void saveTicket(Ticket ticket) {
		this.ticketRepository.save(ticket);
		
	}
	@Override
	public void deleteTicket(Long id) {
		this.ticketRepository.deleteById(id);
		
	}
	@Override
	public Ticket getTicketById(Long id) {
		Ticket ticket=this.ticketRepository.findById(id).get();
		return ticket;
	}

}
