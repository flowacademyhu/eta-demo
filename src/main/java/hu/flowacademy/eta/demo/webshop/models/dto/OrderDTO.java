package hu.flowacademy.eta.demo.webshop.models.dto;

import hu.flowacademy.eta.demo.webshop.models.Currency;
import hu.flowacademy.eta.demo.webshop.models.Order;
import hu.flowacademy.eta.demo.webshop.models.ShippingAddress;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private String orderBy;
    private LocalDateTime timestamp;
    private BigDecimal totalAmount;
    private Currency currency;
    private ShippingAddress shippingAddress;
    private List<Long> productIds;

    public Order toOrder() {
        Order order = new Order();
        order.setTimestamp(LocalDateTime.now());
        order.setOrderBy(orderBy);
        order.setTotalAmount(totalAmount);
        order.setCurrency(currency);
        order.setShippingAddress(shippingAddress);
        return order;
    }
}
