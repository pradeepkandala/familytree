package com.ism.familytree.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class RelationshipDTO {
    private UUID id;
    private UUID fromPersonId;
    private UUID toPersonId;
    private String relType;
    private boolean directional;
    private String description;
    private LocalDate startDate;
}
