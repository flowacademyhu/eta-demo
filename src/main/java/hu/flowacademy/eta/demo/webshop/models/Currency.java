package hu.flowacademy.eta.demo.webshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "currency_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "currency_seq", allocationSize = 1, sequenceName = "currency_seq")
    private Long id;
    @Column
    private String name;
    @Column(name = "_precision")
    private Integer precision;
}
