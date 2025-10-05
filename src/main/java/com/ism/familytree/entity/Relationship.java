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
    @JoinColumn(name = "from_person", referencedColumnName = "id", nullable = false)
    private Person fromPerson;

    @ManyToOne
    @JoinColumn(name = "to_person", referencedColumnName = "id", nullable = false)
    private Person toPerson;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "rel_type", nullable = false)
    private String relType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "directional")
    private Boolean directional = true;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "updated_at", columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    private Boolean deleted = false;
}
