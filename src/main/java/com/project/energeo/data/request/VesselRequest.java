package com.project.energeo.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class VesselRequest {

    private UUID companyId;
    private String title;
    private String image;
    private boolean active;

}
