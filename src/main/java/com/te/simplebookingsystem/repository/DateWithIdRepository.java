package com.te.simplebookingsystem.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.DateWithId;

@Repository
public interface DateWithIdRepository extends JpaRepository<DateWithId, Integer> {

}
