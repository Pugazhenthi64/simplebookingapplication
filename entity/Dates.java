package com.te.simplebookingsystem.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sNo;
	@JsonFormat(pattern = "MM-dd-yyyy",shape =  JsonFormat.Shape.STRING)
	private LocalDate date;
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
}
