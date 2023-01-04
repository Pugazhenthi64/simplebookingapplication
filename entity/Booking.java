package com.te.simplebookingsystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short bookingId;
//	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy")
//	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd'T'HH:mm:ss")
//	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd'T'HH:mm:ss")
	
	@JsonFormat(pattern = "MM-dd-yyyy", shape = JsonFormat.Shape.STRING )
	private LocalDate startDate;
	@JsonFormat(pattern = "MM-dd-yyyy", shape = JsonFormat.Shape.STRING )
	private LocalDate endDate;

	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "booking")
//	@JoinTable(name = "booking_defaultusers",joinColumns = @JoinColumn(name="booking_fk"),
//		inverseJoinColumns = @JoinColumn(name ="default_user_fk"))
	private List<DefaultUsers> defaultUsers = Lists.newArrayList();
		
	@ManyToOne(cascade = CascadeType.ALL)
	private SportField sportField;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private BookStatus bookStatus;
	
}
