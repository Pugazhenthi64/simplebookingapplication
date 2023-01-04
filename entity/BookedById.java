package com.te.simplebookingsystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookedById implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short sNo;
	private Short BookingStatusId;
	private String name;
	private Boolean billingStatus;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bookedById")
	private List<DateWithId> dateWithIds;
	
}
