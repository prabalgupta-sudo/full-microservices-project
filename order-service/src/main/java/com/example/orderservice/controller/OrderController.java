package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/products-from-product-service")
    public Object getProducts() {
        return service.getProductsFromProductService();
    }
}