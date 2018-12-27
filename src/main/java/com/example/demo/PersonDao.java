package com.example.demo;

import java.util.List;

public interface PersonDao {

	List<Person> findByleftJoinOrders();

}