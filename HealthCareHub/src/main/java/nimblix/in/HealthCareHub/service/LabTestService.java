package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.LabTestRequest;
import nimblix.in.HealthCareHub.response.LabTestResponse;

import java.util.List;

public interface LabTestService {

    // ✅ Create LabTest for a specific hospital
    LabTestResponse createLabTest(LabTestRequest request);

    // ✅ Get all LabTests for a specific hospital
    List<LabTestResponse> getLabTestsByHospital(Long hospitalId);

    // ✅ Get LabTest by ID (hospital‑safe)
    LabTestResponse getLabTestById(Long hospitalId, Long labTestId);

    // ✅ Update LabTest for a specific hospital
    LabTestResponse updateLabTest(Long hospitalId, Long labTestId, LabTestRequest request);

    // ✅ Delete LabTest for a specific hospital
    void deleteLabTest(Long hospitalId, Long labTestId);
}
