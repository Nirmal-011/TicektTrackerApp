package com.gl.TicketTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.TicketTracker.entity.Ticket;
import com.gl.TicketTracker.service.TicketService;

@Controller
public class TicketController {
	
	private TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		this.ticketService=ticketService;
	}
	
	@GetMapping("/tickets")
	public String ListAllTicket(Model model) {
		model.addAttribute("ticket",this.ticketService.findAllTickets());
		return "Tickets";
	}
	
	@GetMapping("/addTicket")
	public String newTicket(Model model) {
		Ticket ticket=new Ticket();
		model.addAttribute("ticket",ticket);
		return "AddTicket";
	}
	
	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticket")Ticket ticket) {
		this.ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable("id")Long id) {
		this.ticketService.deleteTicket(id);
		return "redirect:/tickets";
	}
	
	@GetMapping("/edit/{id}")
	public String edtiTicket(@PathVariable Long id,Model model) {
		model.addAttribute("ticket",this.ticketService.getTicketById(id));
		return "updateTicket";
	}
	
	@PostMapping("/updateTicket/{id}")
	public String UpdateTicket(@ModelAttribute("ticket")Ticket ticket,@PathVariable Long id) {
		Ticket existingticket=this.ticketService.getTicketById(id);
		existingticket.setId(id);
		existingticket.setTitle(ticket.getTitle());
		existingticket.setDescription(ticket.getDescription());
		existingticket.setContent(ticket.getContent());
		
		this.ticketService.saveTicket(existingticket);
		return "redirect:/tickets";
	}
	
	@GetMapping("/view/{id}")
	public String ViewTicket(@PathVariable Long id ,Model model) {
		model.addAttribute("ticket", this.ticketService.getTicketById(id));
		return "viewTicket";
		
	}
}
