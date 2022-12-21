package managementLab.quanlyphongmay.Reposibility;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import managementLab.quanlyphongmay.Models.Teacher;

/**
 * LoginRepo
 */
@Repository
public interface TeacherJpaRepo extends JpaRepository<Teacher,Long>{
    Teacher findByTendangnhap(String userName);
}