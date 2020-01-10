package hu.flowacademy.eta.demo.webshop.repository;

import hu.flowacademy.eta.demo.webshop.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
