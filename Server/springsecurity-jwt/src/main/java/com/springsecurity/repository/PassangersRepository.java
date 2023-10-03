package com.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Passanger;

@Repository
public interface PassangersRepository extends CrudRepository<Passanger, Integer> {

	Passanger findByEmail(String email);

	Optional<Passanger> findById(long id);



}
