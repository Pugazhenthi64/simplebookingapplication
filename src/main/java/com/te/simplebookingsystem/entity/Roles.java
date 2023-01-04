package com.te.simplebookingsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Roles {

	@Id
	private Short roleId;
	
	private String roleName;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "roles")
	private List<AppUsers> appUsers = Lists.newArrayList();
}
