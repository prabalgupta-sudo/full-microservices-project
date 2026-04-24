package com.example.orderservice.service;

import com.example.orderservice.client.ProductClient;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ProductClient productClient;

    public OrderService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public Object getProductsFromProductService() {
        return productClient.getProducts();
    }
}