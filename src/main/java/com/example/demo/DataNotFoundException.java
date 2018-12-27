package com.example.demo;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(Long id) {
		super("Could not find data " + id);
	}

	public DataNotFoundException(Integer id) {
		super("Could not find data " + id);
	}

	public DataNotFoundException(String number) {
		super("Could not find data " + number);
	}
}
