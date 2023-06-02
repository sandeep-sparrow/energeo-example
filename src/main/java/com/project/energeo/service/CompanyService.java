package com.project.energeo.service;

import com.project.energeo.data.request.CompanyRequest;
import com.project.energeo.data.response.CompanyResponse;
import com.project.energeo.model.Company;
import com.project.energeo.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final ICompanyRepository iCompanyRepository;

    public void createCompany(CompanyRequest companyRequest){
            Company company = Company.builder()
                    .id(UUID.randomUUID())
                    .companyName(companyRequest.getCompanyName())
                    .companyPhone(companyRequest.getCompanyPhone())
                    .headOffice(companyRequest.isHeadOffice())
                    .companyWebsite(companyRequest.getCompanyWebsite())
                    .address(companyRequest.getAddress())
                    .contactPersonName(companyRequest.getContactPersonName())
                    .contactPersonPhone(companyRequest.getContactPersonPhone())
                    .build();

            try{
                iCompanyRepository.save(company);
                log.info("Company {} is saved", company.getId());
            }catch (Exception exc){
                throw new RuntimeException(exc);
            }

    }
    public List<CompanyResponse> getAllCompanies(){

        try{
            List<Company> companies = iCompanyRepository.findAll();
            return companies.stream().map(this::mapToCompanyResponse).toList();
        }catch (Exception exc){
            throw new RuntimeException(exc);
        }
    }

    public CompanyResponse getCompanyById(String id){

        try{
            Company company = iCompanyRepository.getById(UUID.fromString(id));
            return mapToCompanyResponse(company);
        }catch (Exception exc){
            throw new RuntimeException(exc);
        }
    }

    private CompanyResponse mapToCompanyResponse(Company company){
        return CompanyResponse.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .companyPhone(company.getCompanyPhone())
                .address(company.getAddress())
                .companyWebsite(company.getCompanyWebsite())
                .headOffice(company.isHeadOffice())
                .contactPersonName(company.getContactPersonName())
                .contactPersonPhone(company.getContactPersonPhone())
                .companyLogo(company.getCompanyLogo())
                .build();
    }


}
