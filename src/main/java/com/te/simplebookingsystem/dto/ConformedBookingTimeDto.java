package com.te.simplebookingsystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ConformedBookingTimeDto {

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
