package managementLab.quanlyphongmay.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="giangvien")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tengiangvien;
    private String tendangnhap;
    private String matkhau;
    @OneToMany(targetEntity = ChiTietGhiNhan.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "giangvien_id", referencedColumnName = "id")
    private Set<ChiTietGhiNhan> chiTietGhiNhans = new HashSet<>();
    @OneToMany(targetEntity = ChiTietDayHoc.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "giangvien_id", referencedColumnName = "id")
    private Set<ChiTietDayHoc> ChiTietDayHocs =new HashSet<>();
}
