package com.project.energeo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;

}
