package com.te.simplebookingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.Booking;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Short> {

	public abstract Optional<Booking> findById(Short bookingId);

//	public Optional<Booking> findById(Short bookingId);

}
