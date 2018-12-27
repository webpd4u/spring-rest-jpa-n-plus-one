package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class PhoneController {

	private final PhoneRepository repository;

	public PhoneController(PhoneRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/phones")
	public List<Phone> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/phones/{number}")
	public Phone findByNumber(@PathVariable String number) {
		
		//TODO n + 1 problem
		return repository.findByNumber(number)
				.orElseThrow(() -> new DataNotFoundException(number));
	}
	
	@GetMapping("/phones-dsl/{number}")
	public Phone findByNumberJoinFetch(@PathVariable String number) {
		
		//TODO solution for n + 1 problem
		return repository.findByNumberJoinFetch(number)
				.orElseThrow(() -> new DataNotFoundException(number));
	}
}
