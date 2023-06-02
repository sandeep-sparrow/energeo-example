package com.project.energeo.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class VesselResponse {

    private UUID id;
    private UUID companyId;
    private String title;
    private String image;
    private boolean active;
    
}
