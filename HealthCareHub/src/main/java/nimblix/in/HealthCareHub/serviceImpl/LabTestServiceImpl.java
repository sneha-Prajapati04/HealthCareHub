package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.request.LabTestRequest;
import nimblix.in.HealthCareHub.response.LabTestResponse;
import nimblix.in.HealthCareHub.model.LabTest;
import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.repository.LabTestRepository;
import nimblix.in.HealthCareHub.repository.HospitalRepository;
import nimblix.in.HealthCareHub.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabTestServiceImpl implements LabTestService {

    @Autowired
    private LabTestRepository labTestRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    // ✅ Create LabTest for a specific hospital
    @Override
    public LabTestResponse createLabTest(LabTestRequest request) {
        if (request.getTestName() == null || request.getTestName().isBlank()) {
            throw new IllegalArgumentException("Test name is required");
        }
        if (request.getPrice() == null || request.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        Hospital hospital = hospitalRepository.findById(request.getHospitalId())
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found with id: " + request.getHospitalId()));

        if (labTestRepository.existsByTestNameAndHospital_Id(request.getTestName(), request.getHospitalId())) {
            throw new IllegalStateException("LabTest already exists with name: " + request.getTestName() + " for hospital: " + hospital.getName());
        }

        LabTest labTest = new LabTest();
        labTest.setTestName(request.getTestName());
        labTest.setDescription(request.getDescription());
        labTest.setPrice(request.getPrice());
        labTest.setHospital(hospital);

        LabTest saved = labTestRepository.save(labTest);
        return new LabTestResponse(saved.getId(), saved.getTestName(), saved.getDescription(), saved.getPrice(), hospital.getName());
    }

    // ✅ Get all LabTests for a specific hospital
    @Override
    public List<LabTestResponse> getLabTestsByHospital(Long hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found with id: " + hospitalId));

        List<LabTest> labTests = labTestRepository.findByHospital_Id(hospitalId);
        if (labTests.isEmpty()) {
            throw new IllegalStateException("No LabTests found for hospital: " + hospital.getName());
        }

        return labTests.stream()
                .map(labTest -> new LabTestResponse(
                        labTest.getId(),
                        labTest.getTestName(),
                        labTest.getDescription(),
                        labTest.getPrice(),
                        hospital.getName()
                ))
                .collect(Collectors.toList());
    }

    // ✅ Get LabTest by ID (hospital‑safe)
    @Override
    public LabTestResponse getLabTestById(Long hospitalId, Long labTestId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found with id: " + hospitalId));

        LabTest labTest = labTestRepository.findById(labTestId)
                .orElseThrow(() -> new IllegalArgumentException("LabTest not found with id: " + labTestId));

        if (!labTest.getHospital().getId().equals(hospitalId)) {
            throw new IllegalStateException("LabTest does not belong to hospital: " + hospital.getName());
        }

        return new LabTestResponse(labTest.getId(), labTest.getTestName(), labTest.getDescription(), labTest.getPrice(), hospital.getName());
    }

    // ✅ Update LabTest for a specific hospital
    @Override
    public LabTestResponse updateLabTest(Long hospitalId, Long labTestId, LabTestRequest request) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found with id: " + hospitalId));

        LabTest labTest = labTestRepository.findById(labTestId)
                .orElseThrow(() -> new IllegalArgumentException("LabTest not found with id: " + labTestId));

        if (!labTest.getHospital().getId().equals(hospitalId)) {
            throw new IllegalStateException("LabTest does not belong to hospital: " + hospital.getName());
        }

        if (request.getTestName() == null || request.getTestName().isBlank()) {
            throw new IllegalArgumentException("Test name cannot be blank");
        }
        if (request.getPrice() == null || request.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        labTest.setTestName(request.getTestName());
        labTest.setDescription(request.getDescription());
        labTest.setPrice(request.getPrice());

        LabTest updated = labTestRepository.save(labTest);
        return new LabTestResponse(updated.getId(), updated.getTestName(), updated.getDescription(), updated.getPrice(), hospital.getName());
    }

    // ✅ Delete LabTest for a specific hospital
    @Override
    public void deleteLabTest(Long hospitalId, Long labTestId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found with id: " + hospitalId));

        LabTest labTest = labTestRepository.findById(labTestId)
                .orElseThrow(() -> new IllegalArgumentException("LabTest not found with id: " + labTestId));

        if (!labTest.getHospital().getId().equals(hospitalId)) {
            throw new IllegalStateException("LabTest does not belong to hospital: " + hospital.getName());
        }

        labTestRepository.delete(labTest);
    }
}
