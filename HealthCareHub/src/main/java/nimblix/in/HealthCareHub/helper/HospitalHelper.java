package nimblix.in.HealthCareHub.helper;

import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;

public class HospitalHelper {

    // Convert request DTO to entity
    public static Hospital convertToEntity(HospitalRegistrationRequest request) {
        return Hospital.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .phone(request.getPhone())
                .email(request.getEmail())
                .totalBeds(request.getTotalBeds())
                .build();
    }
}

