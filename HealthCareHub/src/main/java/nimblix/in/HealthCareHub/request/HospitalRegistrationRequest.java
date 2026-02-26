package nimblix.in.HealthCareHub.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRegistrationRequest {
    private String name;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String email;
    private int totalBeds;
}
