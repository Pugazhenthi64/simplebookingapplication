package com.te.simplebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.SportField;

@Repository
public interface SportFieldRepository extends JpaRepository<SportField, Short> {

}
