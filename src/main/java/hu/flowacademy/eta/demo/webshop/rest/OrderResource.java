package hu.flowacademy.eta.demo.webshop.rest;


import hu.flowacademy.eta.demo.webshop.models.Order;
import hu.flowacademy.eta.demo.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{currency}")
    public List<Order> getOrdersByCurrencies(@PathVariable String currency) {
        return orderService.findByCurrencies(currency);
    }
}
