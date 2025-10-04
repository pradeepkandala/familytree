package com.ism.familytree.repository;


import com.ism.familytree.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, UUID> {
    List<Relationship> findByFromPersonId(UUID fromPersonId);
    List<Relationship> findByToPersonId(UUID toPersonId);
}

