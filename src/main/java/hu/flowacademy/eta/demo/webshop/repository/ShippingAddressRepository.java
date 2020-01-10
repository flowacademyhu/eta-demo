package hu.flowacademy.eta.demo.webshop.repository;

import hu.flowacademy.eta.demo.webshop.models.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}
