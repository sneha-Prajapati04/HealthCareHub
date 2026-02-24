package nimblix.in.HealthCareHub.repository;

import nimblix.in.HealthCareHub.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Long> {
}

