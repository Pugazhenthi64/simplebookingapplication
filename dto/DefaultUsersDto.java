package com.te.simplebookingsystem.dto;



import org.springframework.stereotype.Component;

import com.te.simplebookingsystem.entity.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultUsersDto  {

	
	
	private String email;
	private String password;
	private String salt;
	private Integer groupId;
	private String ipAddress;
	private String userName;
	private String rememberCode;
	private Roles roles;
}
