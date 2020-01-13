package hu.flowacademy.eta.demo.webshop.service;

import hu.flowacademy.eta.demo.webshop.models.Product;
import hu.flowacademy.eta.demo.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

}
