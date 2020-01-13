package hu.flowacademy.eta.demo.webshop.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hu.flowacademy.eta.demo.timeoff.model.AvailableHolidays;
import hu.flowacademy.eta.demo.timeoff.model.User;
import hu.flowacademy.eta.demo.timeoff.repository.UserRepository;
import hu.flowacademy.eta.demo.webshop.models.Currency;
import hu.flowacademy.eta.demo.webshop.models.Product;
import hu.flowacademy.eta.demo.webshop.repository.CurrencyRepository;
import hu.flowacademy.eta.demo.webshop.repository.OrderRepository;
import hu.flowacademy.eta.demo.webshop.repository.ProductRepository;
import hu.flowacademy.eta.demo.webshop.repository.ShippingAddressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

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

    @PostConstruct
    public void init() {
        loadCurrencies();
        loadProducts();
        loadUsersAndAvailableHolidays();
    }

    private void loadUsersAndAvailableHolidays() {
        // Create fake objects
        User u = new User();
        u.setUsername("root");
        u.setRole("ADMIN");
        u.setBoss(null);

        AvailableHolidays rootHolidays = new AvailableHolidays();
        //rootHolidays.setCount(Integer.MAX_VALUE);

        // Bind user and holidays together
        rootHolidays.setUser(u);
        u.setAvailableHolidays(rootHolidays);

        userRepository.save(u);
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
            return Files.readAllLines(getFile(s).toPath());
        } catch (IOException e) {
            log.error("missing file: {}", s);
            return List.of();
        }
    }

    private File getFile(String file) {
        return new File("src/main/resources/mocks/" + file);
    }
}
