package nimblix.in.HealthCareHub.repository;

import nimblix.in.HealthCareHub.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Long> {

    // ✅ Check duplicate test by name
    boolean existsByTestName(String testName);

    // ✅ Check duplicate test by name + hospital
    boolean existsByTestNameAndHospital_Id(String testName, Long hospitalId);

    // ✅ Fetch all lab tests for a specific hospital
    List<LabTest> findByHospital_Id(Long hospitalId);
}
