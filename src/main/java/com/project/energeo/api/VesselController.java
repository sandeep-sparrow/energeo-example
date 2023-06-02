package com.project.energeo.api;

import com.project.energeo.data.request.VesselRequest;
import com.project.energeo.data.response.VesselResponse;
import com.project.energeo.service.VesselService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class VesselController {

    public final VesselService vesselService;

    @PostMapping("/vessel")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVessel(@RequestBody VesselRequest vesselRequest){
        vesselService.createVessel(vesselRequest);
    }

    @GetMapping("/vessel")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<VesselResponse> getAllVesselDetails(){ return vesselService.getAllVessels(); }

    @GetMapping("/vessel/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ResponseStatus(HttpStatus.OK)
    public VesselResponse getVesselDetails(@PathVariable("id") String id){
        return vesselService.getVesselById(id);
    }

    @GetMapping("/vessel/company/{companyId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ResponseStatus(HttpStatus.OK)
    public List<VesselResponse> getVesselDetailsByCompanyId(@PathVariable("companyId") String companyId){
        return vesselService.getVesselsByCompanyId(companyId);
    }

    @DeleteMapping("/vessel/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVessel(@PathVariable("id") String id){
        vesselService.deleteVessel(id);
    }

    @PutMapping("/vessel")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateVessel(@RequestBody VesselResponse vesselResponse){
        vesselService.updateVessel(vesselResponse);
    }



}
