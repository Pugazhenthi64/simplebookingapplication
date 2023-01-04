package com.te.simplebookingsystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultUsers implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	private String email;
	private String password;
	private String salt;
	private Integer groupId;
	private String ipAddress;
	private Boolean active = false;
	private String activationCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy hh:mm")
	private LocalDateTime createdOn =LocalDateTime.now();
	private Integer lastLogin;
	private String userName;
	private String forgottenPasswordCode;
	private String rememberCode;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Booking> booking = Lists.newArrayList();

	private List<Roles> roles;
	

	
}
