package com.ism.familytree.controller;

import com.ism.familytree.entity.Person;
import com.ism.familytree.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }
}

