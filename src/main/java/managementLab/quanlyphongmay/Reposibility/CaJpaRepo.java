package managementLab.quanlyphongmay.Reposibility;

import org.springframework.data.jpa.repository.JpaRepository;

import managementLab.quanlyphongmay.Models.Ca;

public interface CaJpaRepo extends JpaRepository<Ca, Long>{
    
}
