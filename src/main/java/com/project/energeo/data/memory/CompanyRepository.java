package com.project.energeo.data.memory;

import com.project.energeo.model.Company;
import com.project.energeo.model.Address;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CompanyRepository {

    public List<Company> getAllCompanyDetails(){

        List<Company> companies = new ArrayList<>();

        companies.add(new Company(UUID.randomUUID(), "grtLabs","12345",
                new Address("Dallas","Texas","DL","TX","TX-123"),
                false, "https://grtlabs.com/", "wasim", "12345", "logo1"));
        companies.add(new Company(UUID.randomUUID(), "grtLabs","12345",
                new Address("Kingston","Texas","DL","TX","TX-123"),
                false, "https://grtlabs.com/", "sheikh", "12345", "logo2"));
        companies.add(new Company(UUID.randomUUID(), "grtLabs","12345",
                new Address("Mumbai","Texas","DL","TX","TX-123"),
                false, "https://grtlabs.com/", "sandeep", "12345", "logo3"));
        companies.add(new Company(UUID.randomUUID(), "grtLabs","12345",
                new Address("China","Texas","DL","TX","TX-123"),
                false, "https://grtlabs.com/", "antivirus", "12345", "logo4"));
        companies.add(new Company(UUID.randomUUID(), "grtLabs","12345",
                new Address("Japan","Texas","DL","TX","TX-123"),
                false, "https://grtlabs.com/", "visual", "12345", "logo5"));

        return companies;
    }

    public Company getCompanyDetailsById(UUID id){

        List<Company> companies = getAllCompanyDetails();

        return companies.stream().filter(c -> c.getId() == id).findAny().orElse(null);
    }

    public void save(Company company) {

        List<Company> companies = getAllCompanyDetails();

        companies.add(company);

    }
}
