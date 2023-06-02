package com.project.energeo.data.request;

import com.project.energeo.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CompanyRequest {

    private String companyName;
    private String companyPhone;
    private Address address;
    private boolean headOffice;
    private String companyWebsite;
    private String contactPersonName;
    private String contactPersonPhone;
    private String companyLogo;

}
