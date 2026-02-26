package nimblix.in.HealthCareHub.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class LabTestRequest {

    @NotBlank(message = "Test name is required")
    private String testName;

    private String description;

    @Positive(message = "Price must be positive")
    private Double price;

    // ✅ Hospital ID for segregation
    private Long hospitalId;

    // Getters and Setters
    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Long getHospitalId() { return hospitalId; }
    public void setHospitalId(Long hospitalId) { this.hospitalId = hospitalId; }
}
