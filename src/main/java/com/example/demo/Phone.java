package com.example.demo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Phone")
@Data
@NoArgsConstructor
public class Phone {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	@Column(name = "number", unique = true)
	private String number;
	
	@JsonBackReference
//	@JsonManagedReference
	@ManyToOne
	private Person person;
	
	public Phone(String number) {
		this.number = number;
	}
	//Getters and setters are omitted for brevity

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		Phone phone = (Phone) o;
		return Objects.equals( number, phone.number );
	}

	@Override
	public int hashCode() {
		return Objects.hash( number );
	}
}