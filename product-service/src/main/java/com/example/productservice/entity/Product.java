package com.example.productservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;
}
