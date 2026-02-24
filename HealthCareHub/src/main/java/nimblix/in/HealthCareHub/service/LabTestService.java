package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.LabTestRequest;
import nimblix.in.HealthCareHub.response.LabTestResponse;

import java.util.List;

public interface LabTestService {
    LabTestResponse createLabTest(LabTestRequest request);
    List<LabTestResponse> getAllLabTests();
    LabTestResponse getLabTestById(Long id);
    LabTestResponse updateLabTest(Long id, LabTestRequest request);
    void deleteLabTest(Long id);
}

