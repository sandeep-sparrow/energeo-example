package com.project.energeo.repository;

import com.project.energeo.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICompanyRepository extends MongoRepository<Company, UUID> {

    Company getById(UUID id);

}
