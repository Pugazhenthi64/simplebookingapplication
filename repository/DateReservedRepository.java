package com.te.simplebookingsystem.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.DateReserved;

@Repository
public interface DateReservedRepository extends JpaRepository<DateReserved, Date> {

}
