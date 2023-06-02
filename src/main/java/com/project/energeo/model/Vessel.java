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

@Document(value="vessel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vessel {

    @Id
    private UUID id;
    private UUID companyId;
    private String title;
    private String image;
    private boolean active;

}
