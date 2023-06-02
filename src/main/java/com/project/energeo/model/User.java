package com.project.energeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(value = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID companyId;
    private String name;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String avatar;
    private Address address;
    private String password;
    private boolean active;
    private Role role;

}
