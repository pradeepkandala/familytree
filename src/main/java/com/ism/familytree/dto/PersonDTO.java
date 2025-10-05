package com.ism.familytree.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class PersonDTO {
    private UUID id;
    private String givenName;
    private String middleName;
    private String familyName;
    private String gender;
    private String gotra;
    private String occupation;
    private String birthplace;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String deathPlace;
    private String religion;
    private String caste;
    private String subCaste;
}
