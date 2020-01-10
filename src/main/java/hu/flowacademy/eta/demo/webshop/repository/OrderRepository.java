package hu.flowacademy.eta.demo.webshop.repository;

import hu.flowacademy.eta.demo.webshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("from Order o where o.currency.name = ?1")
    List<Order> findByCurrenciesName(String curr);

    List<Order> findByCurrency_Name(String curr);

}
