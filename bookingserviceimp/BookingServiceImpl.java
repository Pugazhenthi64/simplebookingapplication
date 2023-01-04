package com.te.simplebookingsystem.bookingserviceimp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.simplebookingsystem.entity.Dates;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.te.simplebookingsystem.bookingserviceInt.BookingInterface;
import com.te.simplebookingsystem.dto.AvailableDate;
import com.te.simplebookingsystem.dto.BookingDto;
import com.te.simplebookingsystem.dto.ConformedBookingTimeDto;
import com.te.simplebookingsystem.dto.DefaultUserUpdate;
import com.te.simplebookingsystem.dto.DefaultUsersDto;
import com.te.simplebookingsystem.dto.GetAllUsers;
import com.te.simplebookingsystem.dto.GetUser;
import com.te.simplebookingsystem.dto.LoginDto;
import com.te.simplebookingsystem.dto.SportsDetailsDto;
import com.te.simplebookingsystem.dto.SportsFieldDto;
import com.te.simplebookingsystem.ecxeptionHandler.SimpleBookingExceptionHandler;
import com.te.simplebookingsystem.entity.BookStatus;
import com.te.simplebookingsystem.entity.BookedById;
import com.te.simplebookingsystem.entity.Booking;
import com.te.simplebookingsystem.entity.DateReserved;
import com.te.simplebookingsystem.entity.DateWithId;
import com.te.simplebookingsystem.entity.DefaultUsers;
import com.te.simplebookingsystem.entity.SportField;
import com.te.simplebookingsystem.entity.SportsDetails;
import com.te.simplebookingsystem.exception.RegistrationNotSuccessfullException;
import com.te.simplebookingsystem.repository.BookStatusRepository;
import com.te.simplebookingsystem.repository.BookedByIdRepository;
import com.te.simplebookingsystem.repository.BookingRepository;
import com.te.simplebookingsystem.repository.DateReservedRepository;
import com.te.simplebookingsystem.repository.DateWithIdRepository;
import com.te.simplebookingsystem.repository.DatesRepository;
import com.te.simplebookingsystem.repository.DefaultUserRepository;
import com.te.simplebookingsystem.repository.SportFieldRepository;
import com.te.simplebookingsystem.repository.SportsDetailsRepostory;

@Service
public class BookingServiceImpl implements BookingInterface{

	@Autowired
	private BookingRepository bookingRepositary;
	@Autowired
	private DateReservedRepository dateReservedRepository;
	@Autowired
	private BookStatusRepository bookStatusRepository;
	@Autowired
	private DatesRepository datesRepository;
	//	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy hh:mm")
	//	private Date lastLogin;
	@Autowired
	private DefaultUserRepository defaultUserRepository;
	@Autowired
	private SportFieldRepository sportFieldRepository;
	@Autowired
	private DateWithIdRepository dateWithIdRepository;
	@Autowired
	private BookedByIdRepository bookedByIdRepository;
	
	@Autowired
	private SportsDetailsRepostory sportsDetailsRepostory;
	@Override
	public Booking register(Booking booking) {

		if(booking != null) {
			SportField sportField = booking.getSportField();
			sportField.setRequestOn(LocalDate.now());
			bookingRepositary.save(booking);
			return booking;
		} else 
			throw new RegistrationNotSuccessfullException("please enter the data");
	}


	@Override
	public DefaultUsersDto creatingAccount(DefaultUsersDto defaultUsersDto) {
		if(defaultUsersDto != null) {
			DefaultUsers defaultUsers = new DefaultUsers();
			BeanUtils.copyProperties(defaultUsersDto, defaultUsers);
			defaultUserRepository.save(defaultUsers);
			return defaultUsersDto;
		} else 
			throw new RegistrationNotSuccessfullException("please enter the data");
	}


	@Override
	public BookingDto register(BookingDto bookingDto, Short id) {
		Booking booking = new Booking();
		DefaultUsers defaultUsers = new DefaultUsers();
		Optional<DefaultUsers> findById = defaultUserRepository.findById(id);
		if(findById.isPresent()) {
			DefaultUsers users = findById.get();
			BeanUtils.copyProperties(bookingDto, booking);
			booking.getDefaultUsers().add(users);				// for that entity its Many relationship so we need to get that next use add method.
			defaultUsers.getBooking().add(booking);
			bookingRepositary.save(booking);
			return bookingDto;
		}else 
			throw new RegistrationNotSuccessfullException("invalid id");
	}


	@Override
	public DefaultUserUpdate DefaultUsersDto(DefaultUserUpdate defaultUserUpdate, Short id) {
		Optional<DefaultUsers> findById = defaultUserRepository.findById(id);
		if(findById.isPresent()) {
			DefaultUsers users = findById.get();
			BeanUtils.copyProperties(defaultUserUpdate, users);
			defaultUserRepository.save(users);
			return defaultUserUpdate;
		} else 
			throw new RegistrationNotSuccessfullException("invalid id");
	}


	@Override
	public BookingDto updateBooking(BookingDto bookingDto, Short bookingId) {
		Optional<Booking> findById = bookingRepositary.findById(bookingId);
		if(findById.isPresent()) {
			Booking book = findById.get();
			BeanUtils.copyProperties(bookingDto, book);
			bookingRepositary.save(book);
			return bookingDto;
		} else 
			throw new RegistrationNotSuccessfullException("invalid id");
	}


	@Override
	public List<GetUser> getAllUsers() {
		GetAllUsers allUsers = new GetAllUsers();
		List<DefaultUsers> findAll = defaultUserRepository.findAll();
		if(findAll!= null) {
			GetUser getUser = new GetUser();
			List<GetUser> lists = new ArrayList();
			for(DefaultUsers defaultUsers : findAll) {
				lists.add(new GetUser(defaultUsers.getId(),defaultUsers.getEmail(), defaultUsers.getSalt(),
						defaultUsers.getGroupId(), defaultUsers.getIpAddress(), defaultUsers.getActive(), defaultUsers.getActivationCode(), defaultUsers.getUserName()));
				
			}
			return lists;
		} else 
			throw new RegistrationNotSuccessfullException("There is no users");
	}


	@Override
	public GetUser showById(Short id) {

		GetUser getUser = new GetUser();
		//		BeanUtils.copyProperties(id, getUser);
		DefaultUsers defaultUser = defaultUserRepository.findById(id).orElse(null);

		if(defaultUser!=null) {
			BeanUtils.copyProperties(defaultUser, getUser);
			getUser.setId(defaultUser.getId());
			getUser.setIpAddress(defaultUser.getIpAddress());
			getUser.setActivationCode(defaultUser.getActivationCode());
			getUser.setActive(defaultUser.getActive());
			getUser.setEmail(defaultUser.getEmail());
			getUser.setUserName(defaultUser.getUserName());
			getUser.setSalt(defaultUser.getSalt());
			//			BeanUtils.copyProperties(defaultUser, getUser);
			return getUser;
		}  else 
			throw new RegistrationNotSuccessfullException("user is not found");
	}


	@Override
	public List<Dates> showAvailable(AvailableDate availableDate) {
		if(availableDate!=null) {
		return getDatesBetweenUsingJava8(availableDate.getStartdate(), availableDate.getEndDate());
//		Dates dates = datesRepositary.findById(availableDate.getDates()).orElse(null);
//		if(dates!= null) {
//
//			return dates;
//		} else if (dates == null) {
//			Dates dateAdd = new Dates();
//			dateAdd.setDate(availableDate.getDates());
//			//			BeanUtils.copyProperties(availableDate, dateAdd);
//			
//			
//			return datesRepositary.save(dateAdd);
		}  else {
			throw new RegistrationNotSuccessfullException("something went wrong with the date");
		}
	}

	
	     public  List<Dates> getDatesBetweenUsingJava8(
			  LocalDate startDate, LocalDate endDate) { 
			    long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
			    LocalDate trailDate=startDate;
			    List<Dates> dates =Lists.newArrayList();
			    for(long i=0 ;i<=numOfDaysBetween;i++) {
			    	Dates date = new Dates();
			    	trailDate=startDate.plusDays(i);
			    	Optional<Dates> findById = datesRepository.findByDate(trailDate);
			    	if(findById.isEmpty()) {
			    		BeanUtils.copyProperties(trailDate, date);
			    		date.setDate(trailDate);
			    		
			    		Dates save = datesRepository.save(date);
			    		
			    		dates.add(date);
			    	} else {
			    		BeanUtils.copyProperties(trailDate, date);
			    		if(findById.isPresent()) {
			    			Dates datesss = findById.get();
			    			dates.add(datesss);
			    		}
			    		
			    	}
			    }
				return dates;
			}

	
	@Override
	public Dates bookingForOneDay(ConformedBookingTimeDto conformedBookingTimeDto, Short id) {
		BookedById bookedById = new BookedById();	//for showing this in Admin controller
		DateWithId dateWithId = new DateWithId();	//for showing that individual hours booked by id;
		DefaultUsers users = defaultUserRepository.findById(id).orElse(null);
		if(users != null) {
			bookedById.setSNo(users.getId());
			bookedById.setName(users.getUserName());
			bookedById.setDateWithIds(null);
			bookedById.setBillingStatus(true);
			Dates dates = datesRepository.findByDate(conformedBookingTimeDto.getDate()).orElse(null);
			if(dates!= null) {
				if(conformedBookingTimeDto.getNineAm() == false) {
					dateWithId.setNineAm(id);
				}
				if(conformedBookingTimeDto.getTen() == false) {
					dateWithId.setTen(id);
				}
				if(conformedBookingTimeDto.getEleven() == false) {
					dateWithId.setEleven(id);
				}
				if(conformedBookingTimeDto.getTwelve() == false) {
					dateWithId.setTwelve(id);
				}
				if(conformedBookingTimeDto.getThirteen() == false) {
					dateWithId.setThirteen(id);
				}
				if(conformedBookingTimeDto.getFourteen() == false) {
					dateWithId.setFourteen(id);
				}
				if(conformedBookingTimeDto.getFifteen() == false) {
					dateWithId.setFifteen(id);
				}
				if(conformedBookingTimeDto.getSixteen() == false) {
					dateWithId.setSixteen(id);
				}
				if(conformedBookingTimeDto.getSeventeen() == false) {
					dateWithId.setSeventeen(id);
				}
				if(conformedBookingTimeDto.getEighteen() == false) {
					dateWithId.setEighteen(id);
				}
				if(conformedBookingTimeDto.getNinteen() == false) {
					dateWithId.setNinteen(id);
				}
				if(conformedBookingTimeDto.getTwenty() == false) {
					dateWithId.setTwenty(id);
				}
				if(conformedBookingTimeDto.getTwentyOne() == false) {
					dateWithId.setTwentyOne(id);
				}
				if(conformedBookingTimeDto.getTwentyTwo() == false) {
					dateWithId.setTwentyTwo(id);
				}
				if(conformedBookingTimeDto.getTwentyThree() == false) {
					dateWithId.setTwentyThree(id);
				}
				BeanUtils.copyProperties(conformedBookingTimeDto, dates);
				Dates booked=datesRepository.save(dates);
				dateWithIdRepository.save(dateWithId);
				dateWithId.setBookedById(bookedById);
				bookedByIdRepository.save(bookedById);
				//bookedById.setDateWithIds(dateWithId);
				//				need to add and set
				return booked;
			}
		} else {
			throw new RegistrationNotSuccessfullException("Booking is not done");
		}
		throw new RegistrationNotSuccessfullException("Something went wrong");
	}
	@Override
	public SportsDetailsDto sportsDetails(SportsDetailsDto sportsDetailsDto) {
		SportsDetails sportsDetails = new SportsDetails();
		BeanUtils.copyProperties(sportsDetailsDto, sportsDetails);
		sportsDetailsRepostory.save(sportsDetails);
		return sportsDetailsDto;
	}





	
	@Override
	public List<SportsDetailsDto> getAllSportDetails() {

		List<SportsDetails> findAll = sportsDetailsRepostory.findAll();
		if(findAll != null) {
			
			
			 List<SportsDetails> collect = findAll.stream().collect(Collectors.toList());
			 List<SportsDetailsDto> all = new ArrayList();
//			 all.addAll(collect)
			for(SportsDetails allDetails  : collect ) {
			all.add(new SportsDetailsDto(allDetails.getSportsName(), allDetails.getCapacity(), allDetails.getPricePerHour()));	
			}
			
		return all;
		}
		throw new RegistrationNotSuccessfullException("Error in server");
		
	}
	
	
	
	@Override
	public SportsDetailsDto updateSportsDetails(SportsDetailsDto sportsDetailsDto) {

		Optional<SportsDetails> findById = sportsDetailsRepostory.findById(sportsDetailsDto.getSportsName());
		if(findById.isPresent()) {
			SportsDetails sportsDetails = findById.get();
			BeanUtils.copyProperties(sportsDetailsDto, sportsDetails);
			sportsDetailsRepostory.save(sportsDetails);
			return sportsDetailsDto;
		}
		return null;
	}


//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		 Optional<DefaultUsers> user = defaultUserRepository.findByUserName(userName);
//		 if(user.isPresent())
//		 {
//			 DefaultUsers defaultUser = user.get();
//			 return new User(userName,defaultUser.getPassword(),
//					 defaultUser.strea
//					 //getRoles()
//					 
////					 .map(role -> new SimpleGrantedAuthority(role))
////					 .collect(Collectors.toList()));
////			 return new User(username,defaultUser.getPassword(),
////					 defaultUser.getRoles()
////					 .stream()
////					 .map(role -> new SimpleGrantedAuthority(role))
////					 .collect(Collectors.toList()));
//		 }else {
//			 throw new InvalidException("user not exist");
//		 }
//		return null;
//	}


	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	
//		 Optional<DefaultUser> user = defaultUserRespositary.findByUserName(username);
//		 if(user.isPresent())
//		 {
//			 DefaultUser defaultUser = user.get();
//			 return new User(username,defaultUser.getPassword(),
//					 defaultUser.getRoles()
//					 .stream()
//					 .map(role -> new SimpleGrantedAuthority(role))
//					 .collect(Collectors.toList()));
//		 }else {
//			 throw new InvalidException("user not exist");
//		 }
//	}


	




























	


}
