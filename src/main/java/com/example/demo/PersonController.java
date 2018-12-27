package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class PersonController {

	private final PersonDao dao;

	public PersonController(PersonDao dao) {
		this.dao = dao;
	}

	@GetMapping("/persons")
	public List<Person> findAll() {

		List<Person> persons = dao.findByleftJoinOrders();
		
		return persons;
		
	}
}
