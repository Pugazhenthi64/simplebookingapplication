package com.te.simplebookingsystem.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvailableDate {

	@JsonFormat(pattern = "MM-dd-yyyy",shape =  JsonFormat.Shape.STRING)
	private LocalDate startdate;
	
	@JsonFormat(pattern = "MM-dd-yyyy",shape =  JsonFormat.Shape.STRING)
	private LocalDate endDate;
}
