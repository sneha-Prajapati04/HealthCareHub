package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.request.LabTestRequest;
import nimblix.in.HealthCareHub.response.LabTestResponse;
import nimblix.in.HealthCareHub.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospitals/{hospitalId}/labtests")
public class DoctorController {

    @Autowired
    private LabTestService labTestService;

    // ✅ Create LabTest for a specific hospital
    @PostMapping
    public LabTestResponse createLabTest(@PathVariable Long hospitalId, @Valid @RequestBody LabTestRequest request) {
        request.setHospitalId(hospitalId); // ensure hospitalId is set
        return labTestService.createLabTest(request);
    }

    // ✅ Get all LabTests for a specific hospital
    @GetMapping
    public List<LabTestResponse> getLabTestsByHospital(@PathVariable Long hospitalId) {
        return labTestService.getLabTestsByHospital(hospitalId);
    }

    // ✅ Get LabTest by ID for a specific hospital
    @GetMapping("/{labTestId}")
    public LabTestResponse getLabTestById(@PathVariable Long hospitalId, @PathVariable Long labTestId) {
        return labTestService.getLabTestById(hospitalId, labTestId);
    }

    // ✅ Update LabTest for a specific hospital
    @PutMapping("/{labTestId}")
    public LabTestResponse updateLabTest(@PathVariable Long hospitalId,
                                         @PathVariable Long labTestId,
                                         @Valid @RequestBody LabTestRequest request) {
        return labTestService.updateLabTest(hospitalId, labTestId, request);
    }

    // ✅ Delete LabTest for a specific hospital
    @DeleteMapping("/{labTestId}")
    public String deleteLabTest(@PathVariable Long hospitalId, @PathVariable Long labTestId) {
        labTestService.deleteLabTest(hospitalId, labTestId);
        return "Lab Test deleted successfully!";
    }
}
