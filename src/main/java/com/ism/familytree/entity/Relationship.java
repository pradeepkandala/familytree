package com.ism.familytree.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "relationship")
public class Relationship {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "from_person", nullable = false)
    private Person fromPerson;

    @ManyToOne
    @JoinColumn(name = "to_person", nullable = false)
    private Person toPerson;

    @Column(name = "rel_type", nullable = false)
    private String relType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    // Getters and Setters
}
