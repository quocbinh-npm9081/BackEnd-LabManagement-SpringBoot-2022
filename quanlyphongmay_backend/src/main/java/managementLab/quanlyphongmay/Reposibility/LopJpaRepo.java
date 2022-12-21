package managementLab.quanlyphongmay.Reposibility;

import org.springframework.data.jpa.repository.JpaRepository;

import managementLab.quanlyphongmay.Models.Lop;

public interface LopJpaRepo extends JpaRepository<Lop, Long> {
    
}
