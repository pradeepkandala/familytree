package com.ism.familytree.repository;


import com.ism.familytree.entity.Person;
import com.ism.familytree.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, UUID> {


    List<Relationship> findAllByFromPerson_IdOrToPerson_Id(UUID fromPersonId, UUID toPersonId);


    List<Relationship> findByRelTypeIgnoreCase(String relType);


    List<Relationship> findByFromPerson_Id(UUID fromPersonId);
    List<Relationship> findByToPerson_Id(UUID toPersonId);


}

