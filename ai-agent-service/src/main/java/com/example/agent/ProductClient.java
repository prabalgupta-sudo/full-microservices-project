package com.example.agent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "product-service", url = "http://product-service:8081")
public interface ProductClient {

    @GetMapping("/products")
    List<Object> getProducts();
}