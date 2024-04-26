package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personService;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() throws Exception {

		return personService.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") Long id) throws Exception {

		return personService.findById(id);
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {

		return personService.create(person);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person, @PathVariable Long id) {

		return personService.update(id, person);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> remove(@PathVariable("id") Long id) throws Exception {

		return personService.remove(id);
	}
}