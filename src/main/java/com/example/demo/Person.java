package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Person")
@Data
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	
//	@JsonBackReference
	@JsonManagedReference
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Phone> phones = new ArrayList<>();

	//Getters and setters are omitted for brevity

	public void addPhone(Phone phone) {
		phones.add( phone );
		phone.setPerson( this );
	}

	public void removePhone(Phone phone) {
		phones.remove( phone );
		phone.setPerson( null );
	}
}