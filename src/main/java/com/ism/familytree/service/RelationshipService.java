package com.ism.familytree.service;

import com.ism.familytree.dto.RelationshipDTO;
import com.ism.familytree.entity.Person;
import com.ism.familytree.entity.Relationship;
import com.ism.familytree.repository.PersonRepository;
import com.ism.familytree.repository.RelationshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;
    private final PersonRepository personRepository;

    public RelationshipService(RelationshipRepository relationshipRepository, PersonRepository personRepository) {
        this.relationshipRepository = relationshipRepository;
        this.personRepository = personRepository;
    }

    /**
     * Create and persist a new relationship.
     */
    public Relationship addRelationship(RelationshipDTO dto) {
        Person from = personRepository.findById(dto.getFromPersonId())
                .orElseThrow(() -> new IllegalArgumentException("From person not found: " + dto.getFromPersonId()));
        Person to = personRepository.findById(dto.getToPersonId())
                .orElseThrow(() -> new IllegalArgumentException("To person not found: " + dto.getToPersonId()));

        Relationship r = new Relationship();
        r.setFromPerson(from);
        r.setToPerson(to);
        r.setRelType(dto.getRelType());
        r.setDirectional(dto.isDirectional());
        r.setDescription(dto.getDescription());
        r.setStartDate(dto.getStartDate());

        // ignore dto.getId(); JPA will generate it
        return relationshipRepository.save(r);
    }


    /**
     * Retrieve a relationship by its ID.
     */
    public Relationship getRelationshipById(UUID id) {
        return relationshipRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Relationship not found: " + id));
    }

    /**
     * Retrieve all relationships for a given person (either as from or to).
     */
    public List<Relationship> getRelationshipsByPerson(UUID personId) {
        return relationshipRepository.findAllByFromPerson_IdOrToPerson_Id(personId, personId);
    }

    /**
     * Delete relationship by ID.
     */
    public void deleteRelationship(UUID id) {
        relationshipRepository.deleteById(id);
    }
    public List<Relationship> getAllRelationships() {
        return relationshipRepository.findAll();
    }

    /**
     * Retrieve all relationships of a given type (e.g., "father", "spouse").
     */
    public List<Relationship> getRelationshipsByType(String relType) {
        return relationshipRepository.findByRelTypeIgnoreCase(relType);
    }

    public List<Relationship> getByRelType(String relType) {
        return relationshipRepository.findByRelTypeIgnoreCase(relType);
    }
}
