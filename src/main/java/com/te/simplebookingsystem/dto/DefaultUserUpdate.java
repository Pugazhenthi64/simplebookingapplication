package com.te.simplebookingsystem.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.te.simplebookingsystem.entity.Booking;
import com.te.simplebookingsystem.entity.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultUserUpdate {


	private String email;
	private String password;
	private String salt;
	private Integer groupId;
	private Boolean active = false;
	private String activationCode;
//	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy hh:mm")
	
	private String userName;
	private String forgottenPasswordCode;
	private String rememberCode;
	private Roles roles;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private List<Booking> booking;
	
}
