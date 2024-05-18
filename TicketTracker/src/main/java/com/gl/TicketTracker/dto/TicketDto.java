package com.gl.TicketTracker.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

	private Long id;

	private String title;

	private String description;

	private String content;

	private LocalDateTime CreatedOn;
	
	private LocalDateTime UpdatedOn;

}
