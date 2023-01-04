package com.te.simplebookingsystem.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.simplebookingsystem.entity.Dates;

public interface DatesRepository extends JpaRepository<Dates, Integer> {

	Optional<Dates> findByDate(LocalDate date);

}
