package com.te.simplebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.AppUsers;
@Repository
public interface AppUsersRepositary extends JpaRepository<AppUsers, String> {

}
