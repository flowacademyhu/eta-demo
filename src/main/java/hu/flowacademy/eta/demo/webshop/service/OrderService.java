package hu.flowacademy.eta.demo.webshop.service;

import hu.flowacademy.eta.demo.webshop.models.Order;
import hu.flowacademy.eta.demo.webshop.models.Product;
import hu.flowacademy.eta.demo.webshop.models.dto.OrderDTO;
import hu.flowacademy.eta.demo.webshop.repository.OrderRepository;
import hu.flowacademy.eta.demo.webshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public List<Order> findByCurrencies(String curr) {
        return orderRepository.findByCurrenciesName(curr);
    }

    public void saveOrder(OrderDTO orderDTO) {
        validateOrder(orderDTO);

        Order order = orderDTO.toOrder();

        List<Product> products = productRepository.findAllById(orderDTO.getProductIds());
        products.stream()
                .forEach(e -> {
                            e.decrementCount();
                            if (e.getCount() == 0) {
                                e.setStatus("sold");
                            }
                            e.setOrder(order);
                        }
                );

        productRepository.saveAll(products);
        orderRepository.save(order);
    }

    private void validateOrder(OrderDTO orderDTO) {
        // Check if we have any out-of-stock of the given products
        if (productRepository.countByStatusAndIdIn("sold", orderDTO.getProductIds()) > 0) {
            // If you want to display which products are out-of-stock, this logic should be refactored a bit
            throw new RuntimeException("Out of stock."); // TODO: beautify, use specific exception (i.e. OutOfStockException)
        }
    }
}
