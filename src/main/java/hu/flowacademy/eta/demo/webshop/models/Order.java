package hu.flowacademy.eta.demo.webshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private Long orderId;
    @Column
    private String orderBy;
    @Column
    private LocalDateTime timestamp;
    @Column
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn
    private Currency currency;

    @OneToOne
    private ShippingAddress shippingAddress;

    @OneToMany(mappedBy = "order")
    private List<Product> products;
}
