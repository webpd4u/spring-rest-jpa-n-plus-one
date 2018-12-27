package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {
//	@Autowired
//	private EntityManager entityManager;
	
	@Bean
	@Transactional
	CommandLineRunner initDatabase(PhoneRepository repository,
			PersonRepository personRepository) {
		return args -> {
			Person person = new Person();

			Phone phone1 = new Phone( "123-456-7890" );
			Phone phone2 = new Phone( "321-654-0987" );
			
			person.addPhone( phone1 );
			person.addPhone( phone2 );
			
			personRepository.save(person);
			
			repository.save(phone1);
			repository.save(phone2);

		};

	}

}
