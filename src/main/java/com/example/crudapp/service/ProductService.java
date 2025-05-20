package com.example.crudapp.service;

import com.example.crudapp.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final String API_URL = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate;

    public ProductService() {
        this.restTemplate = new RestTemplate();
    }

    // Get all products
    public List<Product> getAllProducts() {
        Product[] products = restTemplate.getForObject(API_URL, Product[].class);
        return Arrays.asList(products);
    }

    // Get product by ID
    public Product getProductById(Long id) {
        String url = API_URL + "/" + id;
        return restTemplate.getForObject(url, Product.class);
    }
}
