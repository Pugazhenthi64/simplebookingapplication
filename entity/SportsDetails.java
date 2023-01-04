package com.te.simplebookingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SportsDetails {

	@Id
	private String sportsName;
	private Short capacity;
	private Double pricePerHour;
	
}
