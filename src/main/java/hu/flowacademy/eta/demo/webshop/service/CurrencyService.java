package hu.flowacademy.eta.demo.webshop.service;

import hu.flowacademy.eta.demo.webshop.models.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    Logger logger = LoggerFactory.getLogger(CurrencyService.class);
    
    public List<Currency> findAll() {
        logger.info("findAll called");
        Currency usd = Currency.builder().id(2L).name("USD").build();
        return List.of();
    }
    
}
