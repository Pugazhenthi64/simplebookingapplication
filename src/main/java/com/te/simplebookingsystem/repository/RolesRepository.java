package com.te.simplebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.simplebookingsystem.entity.Roles;
@Repository
public interface RolesRepository extends JpaRepository<Roles, Short> {

}
