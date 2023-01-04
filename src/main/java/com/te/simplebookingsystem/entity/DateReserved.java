package com.te.simplebookingsystem.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateReserved implements Serializable{


	@Id
//	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy hh:mm")
	private String bookedDate;
	
	private Boolean nineAm;
	private Boolean ten;
	private Boolean eleven;
	private Boolean twelve;
	private Boolean thirteen;
	private Boolean fourteen;
	private Boolean fifteen;
	private Boolean sixteen;
	private Boolean seventeen;
	private Boolean eighteen;
	private Boolean ninteen;
	private Boolean twenty;
	private Boolean twentyOne;
	private Boolean twentyTwo;
	private Boolean twentyThree;
	private Boolean status;
}
