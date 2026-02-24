package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.request.LabTestRequest;
import nimblix.in.HealthCareHub.response.LabTestResponse;
import nimblix.in.HealthCareHub.model.LabTest;
import nimblix.in.HealthCareHub.repository.LabTestRepository;
import nimblix.in.HealthCareHub.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabTestServiceImpl implements LabTestService {

    @Autowired
    private LabTestRepository labTestRepository;

    @Override
    public LabTestResponse createLabTest(LabTestRequest request) {
        LabTest labTest = new LabTest();
        labTest.testName = request.getTestName();
        labTest.description = request.getDescription();
        labTest.price = request.getPrice();

        LabTest saved = labTestRepository.save(labTest);
        return new LabTestResponse(saved.id, saved.testName, saved.description, saved.price);
    }

    @Override
    public List<LabTestResponse> getAllLabTests() {
        return labTestRepository.findAll()
                .stream()
                .map(labTest -> new LabTestResponse(
                        labTest.id,
                        labTest.testName,
                        labTest.description,
                        labTest.price
                ))
                .collect(Collectors.toList());
    }

    @Override
    public LabTestResponse getLabTestById(Long id) {
        LabTest labTest = labTestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LabTest not found with id " + id));
        return new LabTestResponse(labTest.id, labTest.testName, labTest.description, labTest.price);
    }

    @Override
    public LabTestResponse updateLabTest(Long id, LabTestRequest request) {
        LabTest labTest = labTestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LabTest not found with id " + id));

        labTest.testName = request.getTestName();
        labTest.description = request.getDescription();
        labTest.price = request.getPrice();

        LabTest updated = labTestRepository.save(labTest);
        return new LabTestResponse(updated.id, updated.testName, updated.description, updated.price);
    }

    @Override
    public void deleteLabTest(Long id) {
        labTestRepository.deleteById(id);
    }
}
