package com.example.demo.products.dto;

import com.example.demo.products.Products;

import java.time.LocalDateTime;

public record ProductResponse(
        Long id,
        String name,
        String description,
        String price,
        String image,
        String tag
) {
    public static ProductResponse fromModel(Products product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImage(),
                product.getTag()
        );
    }

}
