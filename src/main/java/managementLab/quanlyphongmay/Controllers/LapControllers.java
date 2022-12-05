package managementLab.quanlyphongmay.Controllers;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import managementLab.quanlyphongmay.Models.Ca;
import managementLab.quanlyphongmay.Models.ChiTietGhiNhan;
import managementLab.quanlyphongmay.Models.Hocky;
import managementLab.quanlyphongmay.Models.Lop;
import managementLab.quanlyphongmay.Models.May;
import managementLab.quanlyphongmay.Models.MonHoc;
import managementLab.quanlyphongmay.Models.PhongMay;
import managementLab.quanlyphongmay.Models.ResponseObject;
import managementLab.quanlyphongmay.Models.Teacher;
import managementLab.quanlyphongmay.Models.Thu;
import managementLab.quanlyphongmay.Models.TinhTrangMay;
import managementLab.quanlyphongmay.Reposibility.CaJpaRepo;
import managementLab.quanlyphongmay.Reposibility.ChiTietGhiNhanJpaRepo;
import managementLab.quanlyphongmay.Reposibility.HocKyJpaRepo;
import managementLab.quanlyphongmay.Reposibility.LabJpaRepo;
import managementLab.quanlyphongmay.Reposibility.LopJpaRepo;
import managementLab.quanlyphongmay.Reposibility.MayJpaRepo;
import managementLab.quanlyphongmay.Reposibility.MonHocJpaRepo;
import managementLab.quanlyphongmay.Reposibility.PhongMayJpaRepo;
import managementLab.quanlyphongmay.Reposibility.TeacherJpaRepo;
import managementLab.quanlyphongmay.Reposibility.ThuJpaRepo;
import managementLab.quanlyphongmay.Reposibility.TinhTrangMayJpaRepo;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LapControllers {
    @Autowired
    private TeacherJpaRepo TeacherRepo;  
    @Autowired
    private LabJpaRepo LabJpaRepo; 
    @Autowired  
    private MayJpaRepo MayJpaRepo;
    @Autowired 
    private HocKyJpaRepo HocKyJpaRepo;
    @Autowired
    private ThuJpaRepo ThuJpaRepo;
    @Autowired
    private MonHocJpaRepo MonHocJpaRepo;
    @Autowired
    private CaJpaRepo CaJpaRepo;
    @Autowired
    private LopJpaRepo LopJpaRepo;
    @Autowired
    private PhongMayJpaRepo PhongMayJpaRepo;
    @Autowired
    private ChiTietGhiNhanJpaRepo ChiTietGhiNhanJpaRepo;
    @Autowired
    private TinhTrangMayJpaRepo TinhTrangMayJpaRepo;
    //===== AUTHENTICATION =====
    @PostMapping("/loginAccount")
    ResponseEntity<ResponseObject> loginAccount(@RequestBody Teacher teacher){     
        String userName =teacher.getTendangnhap(); 
        String password = teacher.getMatkhau();
        Teacher teacherFinded =TeacherRepo.findByTendangnhap(userName.trim());         
        if(teacherFinded.getTendangnhap().equals(userName) &&teacherFinded.getMatkhau().equals(password)){  
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Login succeses", teacherFinded )
            );
        }   
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
            new ResponseObject("failse", "Locgin Failse", null)
          );
    }
    @PutMapping("/updateStatus")   
   
    ResponseEntity<ResponseObject> updateStatus(@RequestBody May newMay){  
            MayJpaRepo.save(newMay);
                return ResponseEntity.status(HttpStatus.OK).body(
          new ResponseObject("OK","Update product successfully",null)
        );
      }
    //===== GET METHODS

    @GetMapping("/getTeacher/{id}")
    ResponseEntity<ResponseObject>  getTeacher(@PathVariable Long id){
        Optional<Teacher> teacher = TeacherRepo.findById(id);
        if(teacher.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","finded teacher", teacher));           
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("FAILSE","Teacher not exists", null));
    }
    @GetMapping("/getMay/{id}")
    ResponseEntity<ResponseObject> getMay(@PathVariable Long id){
        Optional<May> may = MayJpaRepo.findById(id);

        if(may.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get may successfully",may));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get may failed", null));
    }
    @GetMapping("/getTeacher/{id}/getDetalTeaching")
    ResponseEntity<ResponseObject> getDetalTeaching(@PathVariable Long id){
        Optional<Teacher> teacher = TeacherRepo.findById(id);
        if(teacher.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","finded teacher", teacher));           
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("FAILSE","Teacher not exists", null));
    }
    @GetMapping("tinhTrangMay/{id}")
    ResponseEntity<ResponseObject> getTinhTrangMay(@PathVariable Long id){
        Optional<TinhTrangMay> tinhtrangmay = TinhTrangMayJpaRepo.findById(id);
        if(tinhtrangmay.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","finded teacher", tinhtrangmay));           
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("FAILSE","Teacher not exists", null));
    }
    @GetMapping("/getLabs")
    @JsonIgnore
    ResponseEntity<ResponseObject> getLabs(){
        List<PhongMay> phongMay = LabJpaRepo.findAll();
        if(phongMay.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Get all lab successfully", phongMay));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get all lab failed", null));
    }
    @GetMapping("/getMays")
    @JsonIgnore
    ResponseEntity<ResponseObject> getMays(){
        List<May> mays = MayJpaRepo.findAll();
        if(mays.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Get all may successfully", mays));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get all may failed", null));
    }
 

    @PostMapping("/postHocKy")
    ResponseEntity<ResponseObject> getHocKy(@RequestBody Long id){
        Optional<Hocky> hockies = HocKyJpaRepo.findById(id);
        if(hockies.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get hocky successfully",hockies));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get  hocky failed", null));
    }
    @PostMapping("/postThu")
    ResponseEntity<ResponseObject> getThu(@RequestBody Long id){
        Optional<Thu> thu = ThuJpaRepo.findById(id);
        if(thu.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get thu successfully",thu));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get thu failed", null));
    }
    @PostMapping("/postMonHoc")
    ResponseEntity<ResponseObject> getMonHoc(@RequestBody Long id){
        Optional<MonHoc> monHoc = MonHocJpaRepo.findById(id);
        if(monHoc.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get monHoc successfully",monHoc));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get monHoc failed", null));
    }
    @PostMapping("/postCa")
    ResponseEntity<ResponseObject> getCa(@RequestBody Long id){
        Optional<Ca> ca = CaJpaRepo.findById(id);
        if(ca.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get ca successfully",ca));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get ca failed", null));
    }
    @PostMapping("/postLop")
    ResponseEntity<ResponseObject> getLop(@RequestBody Long id){
        Optional<Lop> lop = LopJpaRepo.findById(id);
        if(lop.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get lop successfully",lop));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get lop failed", null));
    }
    @PostMapping("/postPhongMay")
    ResponseEntity<ResponseObject> getPhongMay(@RequestBody Long id){
        Optional<PhongMay> phongMay = PhongMayJpaRepo.findById(id);

        if(phongMay.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get phongMay successfully",phongMay));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get phongMay failed", null));
    }
  
    @PostMapping("/postChiTietGhiNhan")
    ResponseEntity<ResponseObject> postChiTietGhiNhan(@RequestBody Long id){
        Optional<ChiTietGhiNhan> chitiet_ghinhan = ChiTietGhiNhanJpaRepo.findById(id);
        if(chitiet_ghinhan.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Get chitiet_ghinhan successfully",chitiet_ghinhan));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("FAILSE", "Get chitiet_ghinhan failed", null));
    }
  
}
