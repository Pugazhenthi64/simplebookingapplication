package com.te.simplebookingsystem.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class SportsFieldDto {
	
	
	private Short sportFieldId;
	private String name ;
	private String description;
	private Double priceHourly;
//	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
	private String startingHour;
//	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
	private String endingHour;
//	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "dd-MM-yyyy hh:mm")
	private String requestOn ;
	
	private Short bookingId;
}
