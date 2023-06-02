package com.project.energeo.repository;

import com.project.energeo.model.Vessel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IVesselRepository extends MongoRepository<Vessel, UUID> {

    Vessel getById(UUID id);

    List<Vessel> getByCompanyId(UUID id);

}
