package managementLab.quanlyphongmay.Reposibility;

import org.springframework.data.jpa.repository.JpaRepository;

import managementLab.quanlyphongmay.Models.PhongMay;

public interface PhongMayJpaRepo extends JpaRepository<PhongMay, Long> {
    
}
