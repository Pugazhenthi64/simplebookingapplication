package com.te.simplebookingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.DefaultUsers;

@Repository
public interface DefaultUserRepository extends JpaRepository<DefaultUsers, Short> {

	public Optional<DefaultUsers> findById(Short id);

	public Optional<DefaultUsers> findByUserName(String username);
	

	

}
