package managementLab.quanlyphongmay.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="tinhtrangmay")
public class TinhTrangMay{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "id")
    private Long id;
    @Column(name = "mota_gv")
    private String mota_gv;
    @Column(name = "mota_ktv")
    private String mota_ktv;
    @Column(name = "ngayghinhan")
    private String ngayghinhan;    
    
}
