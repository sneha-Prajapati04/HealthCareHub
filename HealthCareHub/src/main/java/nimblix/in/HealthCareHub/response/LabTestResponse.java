package nimblix.in.HealthCareHub.response;

public class LabTestResponse {

    private Long id;
    private String testName;
    private String description;
    private Double price;
    private String hospitalName; // ✅ segregated output

    // Constructor
    public LabTestResponse(Long id, String testName, String description, Double price, String hospitalName) {
        this.id = id;
        this.testName = testName;
        this.description = description;
        this.price = price;
        this.hospitalName = hospitalName;
    }

    // Getters
    public Long getId() { return id; }
    public String getTestName() { return testName; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }
    public String getHospitalName() { return hospitalName; }
}
