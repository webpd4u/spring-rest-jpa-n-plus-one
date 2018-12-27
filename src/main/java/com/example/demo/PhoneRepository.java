package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
	//TODO n + 1 problem
	Optional<Phone> findByNumber(String number);
	
	@Query("select p from Phone p join fetch p.person where p.number = :number")
	Optional<Phone> findByNumberJoinFetch(@Param("number") String number);
}
