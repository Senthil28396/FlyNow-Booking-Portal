package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.entity.Passanger;
//import com.springsecurity.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<Passanger, Integer> {
//    Optional<UserInfo> findByName(String username);

	Optional<Passanger> findByEmail(String email);

}
