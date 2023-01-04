package com.te.simplebookingsystem.bookingserviceInt;


import java.util.List;

import com.te.simplebookingsystem.entity.Dates;
import com.te.simplebookingsystem.entity.SportField;
import com.google.common.collect.Multimap;
import com.te.simplebookingsystem.dto.AvailableDate;
import com.te.simplebookingsystem.dto.BookingDto;
import com.te.simplebookingsystem.dto.ConformedBookingTimeDto;
import com.te.simplebookingsystem.dto.DefaultUserUpdate;
import com.te.simplebookingsystem.dto.DefaultUsersDto;
import com.te.simplebookingsystem.dto.GetAllUsers;
import com.te.simplebookingsystem.dto.GetUser;
import com.te.simplebookingsystem.dto.SportsDetailsDto;
import com.te.simplebookingsystem.dto.SportsFieldDto;
import com.te.simplebookingsystem.entity.Booking;


public interface BookingInterface {

	Booking register(Booking booking);
	DefaultUsersDto creatingAccount(DefaultUsersDto defaultUsers);
	BookingDto register(BookingDto bookingDto, Short id);
	DefaultUserUpdate DefaultUsersDto(DefaultUserUpdate defaultUserUpdate, Short id);
	BookingDto updateBooking(BookingDto bookingDto, Short bookingId);
	List<GetUser> getAllUsers();
	GetUser showById(Short id);
	List<Dates> showAvailable(AvailableDate availableDate);
	Dates bookingForOneDay(ConformedBookingTimeDto conformedBookingTimeDto, Short id);
	SportsDetailsDto sportsDetails(SportsDetailsDto sportsDetailsDto);
	List<SportsDetailsDto> getAllSportDetails();
	SportsDetailsDto updateSportsDetails(SportsDetailsDto sportsDetailsDto);
	

}





































//DateReserved date(DateReserved dateReserved);
//
////BookStatus bookStatus(BookStatus bookStatus);
//
//
//DefaultUsersDto creatingAccount(DefaultUsersDto defaultUsers);
//
//LoginDto login(LoginDto loginDto);
//
//SportsFieldDto bookingSportsField(SportsFieldDto sportsFieldDto);
//
//BookingDto booking(BookingDto bookingDto);


