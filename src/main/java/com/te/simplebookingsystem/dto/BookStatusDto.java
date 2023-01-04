package com.te.simplebookingsystem.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookStatusDto {

	private Short BookingStatusId;
	private String name;
	
}
