package com.project.energeo.api;

import com.project.energeo.data.request.CompanyRequest;
import com.project.energeo.data.response.CompanyResponse;
import com.project.energeo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/company")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCompany(@RequestBody CompanyRequest companyRequest){
        companyService.createCompany(companyRequest);
    }

    @GetMapping("/company")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyResponse> getAllCompanyDetails(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/company/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ResponseStatus(HttpStatus.OK)
    public CompanyResponse getCompanyDetails(@PathVariable("id") String id){
        return companyService.getCompanyById(id);
    }

}
