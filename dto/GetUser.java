package com.te.simplebookingsystem.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class GetUser {

	private Short id;
	private String email;
	private String salt;
	private Integer groupId;
	private String ipAddress;
	private Boolean active = true;
	private String activationCode;
	private String userName;
}
