package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.request.LabTestRequest;
import nimblix.in.HealthCareHub.response.LabTestResponse;
import nimblix.in.HealthCareHub.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labtests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    // ✅ Create Lab Test
    @PostMapping
    public String createLabTest(@RequestBody LabTestRequest request) {
        labTestService.createLabTest(request);
        return "Lab Test created successfully!";
    }

    // ✅ Get All Lab Tests
    @GetMapping
    public List<LabTestResponse> getAllLabTests() {
        return labTestService.getAllLabTests();
    }

    // ✅ Get Lab Test by ID
    @GetMapping("/{id}")
    public LabTestResponse getLabTestById(@PathVariable Long id) {
        return labTestService.getLabTestById(id);
    }

    // ✅ Update Lab Test
    @PutMapping("/{id}")
    public LabTestResponse updateLabTest(@PathVariable Long id, @RequestBody LabTestRequest request) {
        return labTestService.updateLabTest(id, request);
    }

    // ✅ Delete Lab Test
    @DeleteMapping("/{id}")
    public String deleteLabTest(@PathVariable Long id) {
        labTestService.deleteLabTest(id);
        return "Lab Test deleted successfully!";
    }
}
