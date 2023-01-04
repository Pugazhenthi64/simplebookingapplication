package com.te.simplebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.BookedById;

@Repository
public interface BookedByIdRepository extends JpaRepository<BookedById, Short> {

}
