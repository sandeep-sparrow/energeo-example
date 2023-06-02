package com.project.energeo.data.response;

import com.project.energeo.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class CompanyResponse {

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
