package managementLab.quanlyphongmay.Models;




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
@Table(name="chitiet_ghinhan") 
public class ChiTietGhiNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long giangvien_id;
    private Long tinhtrangmay_id;
}




