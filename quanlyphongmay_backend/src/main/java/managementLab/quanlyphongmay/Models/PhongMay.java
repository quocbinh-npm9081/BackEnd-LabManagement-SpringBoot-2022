package managementLab.quanlyphongmay.Models;

import java.util.List;

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
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name="phongmay")
public class PhongMay{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//
    private Long id;
    private String tenphongmay;
    private String soluongmay;
    @OneToMany(targetEntity = May.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "phongmay_id", referencedColumnName = "id" )
    private List<May> mays;
 
}
