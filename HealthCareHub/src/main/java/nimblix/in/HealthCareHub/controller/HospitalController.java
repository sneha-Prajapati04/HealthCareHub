package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;
import nimblix.in.HealthCareHub.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping("/register")
    public ResponseEntity<String> registerHospital(@RequestBody HospitalRegistrationRequest request) {
        String response = hospitalService.registerHospital(request);
        return ResponseEntity.ok(response);
    }
}
