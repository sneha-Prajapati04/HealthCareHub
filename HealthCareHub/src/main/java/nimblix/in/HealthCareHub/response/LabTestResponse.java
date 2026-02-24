package nimblix.in.HealthCareHub.response;

public class LabTestResponse {
    public Long id;
    public String testName;
    public String description;
    public Double price;

    public LabTestResponse(Long id, String testName, String description, Double price) {
        this.id = id;
        this.testName = testName;
        this.description = description;
        this.price = price;
    }
}


