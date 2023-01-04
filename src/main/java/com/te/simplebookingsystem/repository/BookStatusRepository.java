package com.te.simplebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.BookStatus;

@Repository
public interface BookStatusRepository extends JpaRepository<BookStatus, Short>{

}
