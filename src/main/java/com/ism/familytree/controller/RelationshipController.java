package com.ism.familytree.controller;

import com.ism.familytree.dto.RelationshipDTO;
import com.ism.familytree.entity.Relationship;
import com.ism.familytree.service.RelationshipService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipController {

    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

   /* @PostMapping
    public Relationship addRelationship(@RequestBody RelationshipDTO dto) {
        return relationshipService.addRelationship(dto);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Relationship createRelationship(@RequestBody RelationshipDTO dto) {
        return relationshipService.addRelationship(dto);
    }


    @GetMapping("/{id}")
    public Relationship getRelationship(@PathVariable UUID id) {
        return relationshipService.getRelationshipById(id);
    }

    @GetMapping("/person/{personId}")
    public List<Relationship> getRelationshipsByPerson(@PathVariable UUID personId) {
        return relationshipService.getRelationshipsByPerson(personId);
    }

    @DeleteMapping("/{id}")
    public void deleteRelationship(@PathVariable UUID id) {
        relationshipService.deleteRelationship(id);
    }
    @GetMapping("/type/{relType}")
    public List<Relationship> getByType(@PathVariable String relType) {
        return relationshipService.getByRelType(relType);
    }

    @GetMapping
    public List<Relationship> getAllRelationships() {
        return relationshipService.getAllRelationships();
    }
}
