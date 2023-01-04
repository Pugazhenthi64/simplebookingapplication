package com.te.simplebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.SportsDetails;

@Repository
public interface SportsDetailsRepostory extends JpaRepository<SportsDetails, String>{

}
