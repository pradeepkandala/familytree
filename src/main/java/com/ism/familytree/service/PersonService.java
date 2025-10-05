package com.ism.familytree.service;

import com.ism.familytree.dto.PersonDTO;
import com.ism.familytree.entity.Person;
import com.ism.familytree.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // --- CREATE ---
    public Person addPerson(PersonDTO dto) {
        Person p = new Person();
        p.setGivenName(dto.getGivenName());
        p.setMiddleName(dto.getMiddleName());
        p.setFamilyName(dto.getFamilyName());
        p.setGender(dto.getGender());
        p.setGotra(dto.getGotra());
        p.setOccupation(dto.getOccupation());
        p.setBirthplace(dto.getBirthplace());
        p.setBirthDate(dto.getBirthDate());
        p.setDeathDate(dto.getDeathDate());
        p.setDeathPlace(dto.getDeathPlace());
        p.setReligion(dto.getReligion());
        p.setCaste(dto.getCaste());
        p.setSubCaste(dto.getSubCaste());
        return personRepository.save(p);
    }

    // --- READ ---
    public Person getPersonById(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Person not found with id: " + id
                ));
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> getByGotra(String gotra) {
        return personRepository.findByGotraIgnoreCase(gotra);
    }

    // --- DELETE ---
    public void deletePerson(UUID id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete; person not found: " + id);
        }
        personRepository.deleteById(id);
    }
}
