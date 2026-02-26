package nimblix.in.HealthCareHub.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import nimblix.in.HealthCareHub.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findByName(String name);
}
