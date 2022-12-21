package managementLab.quanlyphongmay.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * May
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name="may")
public class May {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//
    @Column(name = "id")
    private Long id;
    @Column(name = "sothutumay")
    private Integer sothutumay;
    @Column(name = "tinhtrang")
    private String tinhtrang;
   // @JsonIgnore
    @OneToMany(targetEntity =  TinhTrangMay.class ,  cascade = CascadeType.ALL)
    @JoinColumn(name="may_id",referencedColumnName = "id")
    private List<TinhTrangMay> tinhtrangmays = new ArrayList<>();
}