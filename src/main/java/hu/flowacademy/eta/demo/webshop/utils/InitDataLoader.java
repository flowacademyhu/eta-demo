package hu.flowacademy.eta.demo.webshop.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mysql.cj.log.LogFactory;
import hu.flowacademy.eta.demo.config.models.Role;
import hu.flowacademy.eta.demo.config.models.User;
import hu.flowacademy.eta.demo.config.repo.UserRepository;
import hu.flowacademy.eta.demo.webshop.models.Currency;
import hu.flowacademy.eta.demo.webshop.models.Product;
import hu.flowacademy.eta.demo.webshop.models.ShippingAddress;
import hu.flowacademy.eta.demo.webshop.repository.CurrencyRepository;
import hu.flowacademy.eta.demo.webshop.repository.OrderRepository;
import hu.flowacademy.eta.demo.webshop.repository.ProductRepository;
import hu.flowacademy.eta.demo.webshop.repository.ShippingAddressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
@AllArgsConstructor
public class InitDataLoader {

    private final CurrencyRepository currencyRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ShippingAddressRepository shippingAddressRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    public InitDataLoader(CurrencyRepository currencyRepository, OrderRepository orderRepository, ProductRepository productRepository, ShippingAddressRepository shippingAddressRepository) {
//        this.currencyRepository = currencyRepository;
//        this.orderRepository = orderRepository;
//        this.productRepository = productRepository;
//        this.shippingAddressRepository = shippingAddressRepository;
//    }

    @PostConstruct
    public void init() {
        loadCurrencies();
        loadProducts();
        loadUsers();
    }

    private void loadUsers() {
        userRepository.save(User.builder().username("john").password(bCryptPasswordEncoder.encode("123")).role(Role.USER).build());
        userRepository.save(User.builder().username("peter").password(bCryptPasswordEncoder.encode("999")).role(Role.ADMIN).build());
        userRepository.save(User.builder().username("moderator").password(bCryptPasswordEncoder.encode("9876")).role(Role.MODERATOR).build());
    }

    public void loadCurrencies() {
        this.currencyRepository.saveAll(
                new Gson().fromJson(String.join("", getLines("currencies.json")),
                        new TypeToken<List<Currency>>() {
                        }.getType())
        );
    }

    public void loadProducts() {
        List<Product> products = new Gson().fromJson(String.join("", getLines("products.json")),
                new TypeToken<List<Product>>() {
                }.getType());
        products.stream().peek(m -> m.setCreatedAt(LocalDateTime.now()))
                .forEach(this.productRepository::save);
    }

    private List<String> getLines(String s) {
        try {
            return Files.readAllLines(new File("src/main/resources/mocks/" + s).toPath());
        } catch (IOException e) {
            log.error("missing file: {}", s);
            return List.of();
        }
    }
}
