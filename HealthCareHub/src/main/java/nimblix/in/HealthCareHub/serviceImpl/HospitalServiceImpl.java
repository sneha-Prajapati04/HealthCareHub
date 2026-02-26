package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.repository.HospitalRepository;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;
import nimblix.in.HealthCareHub.service.HospitalService;
import nimblix.in.HealthCareHub.constants.HealthCareConstants;
import nimblix.in.HealthCareHub.helper.HospitalHelper;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public String registerHospital(HospitalRegistrationRequest request) {
        // Check if hospital already exists
        if (hospitalRepository.findByName(request.getName()).isPresent()) {
            return HealthCareConstants.HOSPITAL_EXISTS;
        }

        // Use helper to convert DTO → entity
        Hospital hospital = HospitalHelper.convertToEntity(request);

        hospitalRepository.save(hospital);

        return HealthCareConstants.HOSPITAL_REGISTERED;
    }
}
