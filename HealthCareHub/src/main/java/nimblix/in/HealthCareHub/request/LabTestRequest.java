package nimblix.in.HealthCareHub.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class LabTestRequest {

    @NotNull(message = "Test name cannot be null")
    @Size(min = 3, max = 50, message = "Test name must be between 3 and 50 characters")
    private String testName;

    @Size(min = 10, max = 200, message = "Description must be between 10 and 200 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 100, message = "Price must be at least 100")
    @Max(value = 10000, message = "Price must not exceed 10000")
    private Double price;

    // Getters and Setters
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}



