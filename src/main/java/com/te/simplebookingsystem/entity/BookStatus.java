package com.te.simplebookingsystem.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookStatus  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short BookingStatusId;
	private String name;
	
	
	
}
