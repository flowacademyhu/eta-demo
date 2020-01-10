package hu.flowacademy.eta.demo.webshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_seq", allocationSize = 1, sequenceName = "product_seq")
    private Long id;

    @Column
    private String productName;
    @Column
    private String details;
    @Column
    private BigDecimal amount;
    @Column
    private Integer count;

    // should be: created, published, sold
    @Column
    private String status;

    @Column
    private String createdBy;
    @Column
    private LocalDateTime createdAt;

    @Column
    private String updatedBy;
    @Column
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn
    private Order order;
}
