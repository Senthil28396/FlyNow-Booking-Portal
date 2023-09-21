package com.airline.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.ticketbooking.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
