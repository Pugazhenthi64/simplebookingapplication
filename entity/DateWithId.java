package com.te.simplebookingsystem.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class DateWithId {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sNo;
	private LocalDate date;
	private Short nineAm;
	private Short ten;
	private Short eleven;
	private Short twelve;
	private Short thirteen;
	private Short fourteen;
	private Short fifteen;
	private Short sixteen;
	private Short seventeen;
	private Short eighteen;
	private Short ninteen;
	private Short twenty;
	private Short twentyOne;
	private Short twentyTwo;
	private Short twentyThree;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private BookedById bookedById;
}
