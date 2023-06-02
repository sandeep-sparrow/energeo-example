package com.project.energeo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Document(value = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    private UUID id;
    private String companyName;
    private String companyPhone;
    private Address address;
    private boolean headOffice;
    private String companyWebsite;
    private String contactPersonName;
    private String contactPersonPhone;
    private String companyLogo;

}
