package com.ism.familytree.controller;

import com.ism.familytree.entity.Relationship;
import com.ism.familytree.repository.RelationshipRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipController {

    private final RelationshipRepository relationshipRepository;

    public RelationshipController(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    @GetMapping
    public List<Relationship> getAllRelationships() {
        return relationshipRepository.findAll();
    }

    @PostMapping
    public Relationship createRelationship(@RequestBody Relationship relationship) {
        return relationshipRepository.save(relationship);
    }

    @GetMapping("/from/{personId}")
    public List<Relationship> getRelationshipsFrom(@PathVariable UUID personId) {
        return relationshipRepository.findByFromPersonId(personId);
    }

    @GetMapping("/to/{personId}")
    public List<Relationship> getRelationshipsTo(@PathVariable UUID personId) {
        return relationshipRepository.findByToPersonId(personId);
    }
}
