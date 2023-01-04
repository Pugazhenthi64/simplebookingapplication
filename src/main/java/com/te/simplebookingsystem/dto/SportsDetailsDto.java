package com.te.simplebookingsystem.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SportsDetailsDto {

	
	private String sportsName;
	private Short capacity;
	private Double pricePerHour;
}
