package com.te.simplebookingsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.te.simplebookingsystem.entity.DefaultUsers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {

	
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy hh:mm")
	
	@JsonFormat(pattern = "MM-dd-yyyy", shape = JsonFormat.Shape.STRING )
	private LocalDate startDate;
	@JsonFormat(pattern = "MM-dd-yyyy", shape = JsonFormat.Shape.STRING )
	private LocalDate endDate;
	
	private List<DefaultUsers> defaultUsers = Lists.newArrayList();
	
	
	
	
}
	
