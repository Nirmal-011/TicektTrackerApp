package com.gl.TicketTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.TicketTracker.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
