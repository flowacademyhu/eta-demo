package hu.flowacademy.eta.demo.webshop.utils;

import hu.flowacademy.eta.demo.webshop.models.Currency;
import hu.flowacademy.eta.demo.webshop.models.ShippingAddress;
import hu.flowacademy.eta.demo.webshop.repository.CurrencyRepository;
import hu.flowacademy.eta.demo.webshop.repository.OrderRepository;
import hu.flowacademy.eta.demo.webshop.repository.ProductRepository;
import hu.flowacademy.eta.demo.webshop.repository.ShippingAddressRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class InitDataLoader {

//    private final CurrencyRepository currencyRepository;
//    private final OrderRepository orderRepository;
//    private final ProductRepository productRepository;
//    private final ShippingAddressRepository shippingAddressRepository;
//
//    public InitDataLoader(CurrencyRepository currencyRepository, OrderRepository orderRepository, ProductRepository productRepository, ShippingAddressRepository shippingAddressRepository) {
//        this.currencyRepository = currencyRepository;
//        this.orderRepository = orderRepository;
//        this.productRepository = productRepository;
//        this.shippingAddressRepository = shippingAddressRepository;
//    }
//
//    public void loadCurrencies() {
//    }
}
