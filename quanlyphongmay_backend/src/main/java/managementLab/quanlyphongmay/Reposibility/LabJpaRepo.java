package managementLab.quanlyphongmay.Reposibility;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import managementLab.quanlyphongmay.Models.PhongMay;

public interface LabJpaRepo extends JpaRepository<PhongMay, Long>{
    List<PhongMay> findByTenphongmay(String labName);
}
