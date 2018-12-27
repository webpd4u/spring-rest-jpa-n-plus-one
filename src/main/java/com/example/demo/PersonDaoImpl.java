package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class PersonDaoImpl implements PersonDao {
	@PersistenceContext
	private EntityManager em;

	//TODO fetchJoin() -> solves n + 1 problem
	@Override
	public List<Person> findByleftJoinOrders() {
		final JPAQuery<Person> query = new JPAQuery<>(em);
		QPerson person = QPerson.person;
		QPhone phone = QPhone.phone;
		return query.from(person).distinct().leftJoin(person.phones, phone).fetchJoin().fetch();
	}

}
