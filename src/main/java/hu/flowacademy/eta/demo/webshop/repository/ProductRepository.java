package hu.flowacademy.eta.demo.webshop.repository;

import hu.flowacademy.eta.demo.webshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
