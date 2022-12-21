package managementLab.quanlyphongmay.Models;

import java.sql.Date;

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
@Table(name="chitiet_dayhoc")
public class ChiTietDayHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//
    private Long id;
    private Long hocky_id;
    private Long thu_id;
    private Long mamon_id;
    private Long ca_id;
    private Long lop_id;
    private Long phongmay_id;
    private Date ngaybatdau;
    private Date ngayketthuc;
}
