package managementLab.quanlyphongmay.Reposibility;

import org.springframework.data.jpa.repository.JpaRepository;

import managementLab.quanlyphongmay.Models.MonHoc;

public interface MonHocJpaRepo extends JpaRepository<MonHoc, Long>{
    
}
