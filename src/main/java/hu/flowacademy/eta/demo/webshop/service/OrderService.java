package hu.flowacademy.eta.demo.webshop.service;

import hu.flowacademy.eta.demo.webshop.models.Order;
import hu.flowacademy.eta.demo.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findByCurrencies(String curr) {
        return orderRepository.findByCurrenciesName(curr);
    }
}
