package hu.flowacademy.eta.demo.webshop.repository;

import hu.flowacademy.eta.demo.webshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
