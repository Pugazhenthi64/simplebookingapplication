package com.te.simplebookingsystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportField implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short sportFieldId;
	private String name ;
	private String description;
	private Double priceHourly;
//	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "HH", shape = JsonFormat.Shape.STRING )
	private LocalTime startingHour;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
	@JsonFormat(pattern = "HH", shape = JsonFormat.Shape.STRING )
	private LocalTime endingHour;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "dd-MM-yyyy hh:mm")
	@JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING )
	private LocalDate requestOn;


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "sportField")
	private java.util.List<Booking> bookings;
	
}

//@JsonFormat(pattern = "HH:mm:ss[.SSS][.SS][.S]",shape = JsonFormat.Shape.STRING)
//private Instant startingHour;


//@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="HH")
//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH")


//private LocalTime startingHour;
//@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="HH")
//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH")

//private LocalTime endingHour;
