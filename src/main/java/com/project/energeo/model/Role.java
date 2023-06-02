package com.project.energeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private int id;
    private String titles;
    private boolean active;

}
