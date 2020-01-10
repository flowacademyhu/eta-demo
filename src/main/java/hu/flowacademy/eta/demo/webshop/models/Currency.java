package hu.flowacademy.eta.demo.webshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    @Id
    private Long id;
    @Column
    private String name;
    @Column(name = "_precision")
    private Integer precision;
}
