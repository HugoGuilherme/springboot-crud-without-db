package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	List<Person> persons = new ArrayList<>();

	public List<Person> findAll() {

		return persons;
	}

	public Person findById(Long id) {

		logger.info("Finding one Person!");

		for (Person person : persons) {
			if (person.getId().equals(id)) {
				return person;
			}
		}

		return null;
	}

	public Person create(Person person) {
		persons.add(person);

		return findById(person.getId());
	}

	public Person update(Long id, Person person) {

		for (int i = 0; i < persons.size(); i++) {

			if (persons.get(i).getId().equals(id)) {

				persons.set(i, person);

				return findById(person.getId());
			}
		}
		return null;
	}

	public List<Person> remove(Long id) {

		Person person = findById(id);

		persons.remove(person);

		return findAll();
	}
}
