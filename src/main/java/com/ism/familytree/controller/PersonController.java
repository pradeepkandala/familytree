package com.ism.familytree.controller;

import com.ism.familytree.dto.PersonDTO;
import com.ism.familytree.entity.Person;
import com.ism.familytree.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // --- CREATE ---
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody PersonDTO dto) {
        return personService.addPerson(dto);
    }

    // --- READ ---
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable UUID id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/gotra/{gotra}")
    public List<Person> getByGotra(@PathVariable String gotra) {
        return personService.getByGotra(gotra);
    }

    // --- DELETE ---
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable UUID id) {
        personService.deletePerson(id);
    }
}
