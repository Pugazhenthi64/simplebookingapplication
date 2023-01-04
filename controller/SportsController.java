package com.te.simplebookingsystem.controller;

import java.util.Arrays;
import java.util.List;

import javax.xml.transform.ErrorListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.simplebookingsystem.entity.Dates;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.te.simplebookingsystem.bookingserviceInt.BookingInterface;
import com.te.simplebookingsystem.dto.AvailableDate;
import com.te.simplebookingsystem.dto.BookingDto;
import com.te.simplebookingsystem.dto.ConformedBookingTimeDto;
import com.te.simplebookingsystem.dto.DefaultUserUpdate;
import com.te.simplebookingsystem.dto.DefaultUsersDto;
import com.te.simplebookingsystem.dto.GetAllUsers;
import com.te.simplebookingsystem.dto.GetUser;
import com.te.simplebookingsystem.dto.SportsDetailsDto;
import com.te.simplebookingsystem.dto.SportsFieldDto;
import com.te.simplebookingsystem.entity.BookStatus;
import com.te.simplebookingsystem.entity.Booking;
import com.te.simplebookingsystem.entity.DateReserved;
import com.te.simplebookingsystem.entity.SportField;
import com.te.simplebookingsystem.response.ResponsePage;

@RestController
public class SportsController {

	@Autowired
	private ResponsePage responsePage;

	@Autowired
	private BookingInterface bookingInterface;





	@PostMapping("/Bookingall")
	ResponseEntity<ResponsePage> register(@RequestBody Booking booking){
		Booking register = bookingInterface.register(booking);
		if(register!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(register);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}

	@PostMapping("/register")
	ResponseEntity<ResponsePage> creatingAccount(@RequestBody DefaultUsersDto defaultUsers){
		DefaultUsersDto creatingAccount = bookingInterface.creatingAccount(defaultUsers);
		if(creatingAccount != null) {
			responsePage.setErrMsg(false);
			responsePage.setData(creatingAccount);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);
		}
		return null;
	}

	@PostMapping("/booking")
	ResponseEntity<ResponsePage> booking(@RequestBody BookingDto bookingDto,Short id){
		BookingDto register = bookingInterface.register(bookingDto,id);
		if(register!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(register);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}

	@PostMapping("/updateusers")
	ResponseEntity<ResponsePage> updateUser(@RequestBody DefaultUserUpdate defaultUserUpdate,Short id){
		DefaultUserUpdate register = bookingInterface.DefaultUsersDto(defaultUserUpdate,id);
		if(register!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(register);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}

	@PostMapping("/updatebooking")
	ResponseEntity<ResponsePage> updateBooking(@RequestBody BookingDto bookingDto,Short bookingId){
		BookingDto register = bookingInterface.updateBooking(bookingDto,bookingId);
		if(register!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(register);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);

		}
		return null;
	}

	@GetMapping("/Users")
	ResponseEntity<ResponsePage> getAllUsers(){
		List<GetUser> allUsers  = bookingInterface.getAllUsers();
		if(allUsers!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(Arrays.asList(allUsers));
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}

	@GetMapping("/user")
	ResponseEntity<ResponsePage> showById(Short id){
		GetUser getUser = bookingInterface.showById(id);
		if(getUser!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(getUser);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}

	@PostMapping("/availabeforday")
	ResponseEntity<ResponsePage> showAvailable(@RequestBody AvailableDate availableDate){
		List<Dates> showAvailable = bookingInterface.showAvailable(availableDate);
		if(showAvailable!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(Arrays.asList(showAvailable));
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}


	@PostMapping("/bookingforoneday")
	ResponseEntity<ResponsePage> bookingForOneDay(@RequestBody ConformedBookingTimeDto conformedBookingTimeDto,Short id){
		Dates booked = bookingInterface.bookingForOneDay(conformedBookingTimeDto,id);
		if(booked!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(booked);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);

		}
		return null;
	}

	@PostMapping("/SportsDetails")
	ResponseEntity<ResponsePage> sportsDetails(@RequestBody SportsDetailsDto sportsDetailsDto){
		SportsDetailsDto sportsdetail = bookingInterface.sportsDetails(sportsDetailsDto);
		if(sportsdetail!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(sportsdetail);
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}

	@PutMapping("/updatesportsDetails")
	ResponseEntity<ResponsePage> updateSportsDetails(@RequestBody SportsDetailsDto sportsDetailsDto){
		SportsDetailsDto updateSportsDetails = bookingInterface.updateSportsDetails(sportsDetailsDto);
		if(updateSportsDetails!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(Arrays.asList(updateSportsDetails));
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage,HttpStatus.ACCEPTED);

		}
		return null;
	}


	@GetMapping("/getsportsdetails")
	ResponseEntity<ResponsePage> getAllSportDetails(){
		List<SportsDetailsDto> allSportDetails = bookingInterface.getAllSportDetails();
		if(allSportDetails!= null) {
			responsePage.setErrMsg(false);
			responsePage.setData(Arrays.asList(allSportDetails));
			responsePage.setMessage("Created successfull");
			responsePage.setStatus(200);
			return new ResponseEntity<ResponsePage>(responsePage, HttpStatus.ACCEPTED);

		}
		return null;
	}




	//	/*
	//	 * 
	//	 * This method will work for booking and register.
	//	 */
	//	
	//	@PostMapping("/bookingall")
	//	ResponseEntity<ResponsePage> register(@RequestBody Booking booking){
	//		Booking register = bookingInterface.register(booking);
	//		if(register!= null) {
	//			responsePage.setErrMsg(false);
	//			responsePage.setData(register);
	//			responsePage.setMessage("Created successfull");
	//			responsePage.setStatus(200);
	//			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);
	//			
	//		}
	//		return null;
	//	}
	//	/*
	//	 * This method is used for only booking.
	//	 */
	//	
	//	@PostMapping("/booking")
	//	ResponseEntity<ResponsePage> booking(@RequestBody BookingDto bookingDto){
	//		BookingDto register = bookingInterface.booking(bookingDto);
	//		if(register!= null) {
	//			responsePage.setErrMsg(false);
	//			responsePage.setData(register);
	//			responsePage.setMessage("Created successfull");
	//			responsePage.setStatus(200);
	//			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);
	//			
	//		}
	//		return null;
	//	}
	//	
	//	@PostMapping("/date")
	//	ResponseEntity<ResponsePage> date(@RequestBody DateReserved dateReserved){
	//		DateReserved register = bookingInterface.date(dateReserved);
	//		if(register!= null) {
	//			responsePage.setErrMsg(false);
	//			responsePage.setData(register);
	//			responsePage.setMessage("Created successfull");
	//			responsePage.setStatus(200);
	//			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);
	//			
	//		}
	//		return null;
	//	}
	//	
	////	@PostMapping("/bookstatus")
	////	ResponseEntity<ResponsePage> bookStatus(@RequestBody BookStatus bookStatus){
	////		BookStatus register = bookingInterface.bookStatus(bookStatus);
	////		if(register!= null) {
	////			responsePage.setErrMsg(false);
	////			responsePage.setData(register);
	////			responsePage.setMessage("Created successfull");
	////			responsePage.setStatus(200);
	////			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);
	////			
	////		}
	////		return null;
	////	}
	//	
	//	@PostMapping("/sportsfiels")
	//	ResponseEntity<ResponsePage> bookingSportsField(@RequestBody SportsFieldDto sportsFieldDto ){
	//		SportsFieldDto register = bookingInterface.bookingSportsField(sportsFieldDto);
	//		if(register!= null) {
	//			responsePage.setErrMsg(false);
	//			responsePage.setData(register);
	//			responsePage.setMessage("Created successfull");
	//			responsePage.setStatus(200);
	//			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);
	//			
	//		}
	//		return null;
	//	}
	//	
	//	@PostMapping("/register")
	//	ResponseEntity<ResponsePage> creatingAccount(@RequestBody DefaultUsersDto defaultUsers){
	//	 DefaultUsersDto creatingAccount = bookingInterface.creatingAccount(defaultUsers);
	//		if(creatingAccount != null) {
	//			responsePage.setErrMsg(false);
	//			responsePage.setData(creatingAccount);
	//			responsePage.setMessage("Created successfull");
	//			responsePage.setStatus(200);
	//			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);
	//		}
	//		return null;
	//	}
	//	
	//	@GetMapping("/login")
	//			ResponseEntity<ResponsePage> login(@RequestBody LoginDto loginDto) {
	//		DefaultUsers login = bookingInterface.login(loginDto);
	//		if(login != null) {
	//			responsePage.setErrMsg(false);
	//			responsePage.setData(login);
	//			responsePage.setMessage("Created successfull");
	//			responsePage.setStatus(200);
	//			return new ResponseEntity<ResponsePage>(HttpStatus.ACCEPTED);
	//		}
	//		return null;
	//	}
	//			

}
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-security</artifactId>
//</dependency>
//
//<dependency>
//<groupId>org.springframework.security</groupId>
//<artifactId>spring-security-test</artifactId>
//<scope>test</scope>
//</dependency>