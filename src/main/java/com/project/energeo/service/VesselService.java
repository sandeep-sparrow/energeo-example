package com.project.energeo.service;

import com.project.energeo.data.request.VesselRequest;
import com.project.energeo.data.response.VesselResponse;
import com.project.energeo.model.Vessel;
import com.project.energeo.repository.IVesselRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class VesselService {

    private final IVesselRepository iVesselRepository;

    public void createVessel(VesselRequest vesselRequest) {
        Vessel vessel = Vessel.builder()
                .id(UUID.randomUUID())
                .companyId(vesselRequest.getCompanyId())
                .title(vesselRequest.getTitle())
                .active(vesselRequest.isActive())
                .image(vesselRequest.getImage())
                .build();

        try{
            iVesselRepository.save(vessel);
            log.info("Vessel {} is saved", vessel.getId());
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }

    }

    public List<VesselResponse> getAllVessels(){

        try{
            List<Vessel> vessels = iVesselRepository.findAll();
            return vessels.stream().map(this::mapToVesselResponse).toList();
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }

    }

    public VesselResponse getVesselById(String id){
        Vessel vessel = iVesselRepository.getById(UUID.fromString(id));

        return mapToVesselResponse(vessel);
    }

    public List<VesselResponse> getVesselsByCompanyId(String id){

        try{
            List<Vessel> vessels = iVesselRepository.getByCompanyId(UUID.fromString(id));
            return vessels.stream().map(this::mapToVesselResponse).toList();
        } catch (Exception exc) {
            throw new NullPointerException("Vessel is not found  company id: " + id);
        }

    }

    public void deleteVessel(String id){
        Vessel vessel = iVesselRepository.getById(UUID.fromString(id));

        if(vessel != null){
            iVesselRepository.deleteById(UUID.fromString(id));
            log.info("Vessel {} is deleted", vessel.getId());
        }else{
            throw new NullPointerException("Vessel is not found for id: " + id);
        }
    }

    public void updateVessel(VesselResponse vesselResponse) {
        Vessel vessel = iVesselRepository.getById(vesselResponse.getId());

        if(vessel != null){
            vessel = Vessel.builder()
                    .id(vesselResponse.getId())
                    .companyId(vesselResponse.getCompanyId())
                    .title(vesselResponse.getTitle())
                    .active(vesselResponse.isActive())
                    .image(vesselResponse.getImage())
                    .build();
            iVesselRepository.save(vessel);
            log.info("Vessel {} is update", vessel.getId());
        }else{
            throw new NullPointerException("Vessel is not found for id: " + vesselResponse.getId());
        }
    }

    private VesselResponse mapToVesselResponse(Vessel vessel) {

        return VesselResponse.builder()
                .id(vessel.getId())
                .companyId(vessel.getCompanyId())
                .title(vessel.getTitle())
                .active(vessel.isActive())
                .image(vessel.getImage())
                .build();
    }
}
