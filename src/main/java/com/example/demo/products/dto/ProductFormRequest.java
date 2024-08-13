package com.example.demo.products.dto;

import com.example.demo.products.Products;

public record ProductFormRequest(
        String name,
        String description,
        String price,
        String image,
        String tag
) {
    public Products toModel() {
        return Products.builder()
                .name(name)
                .description(description)
                .price(price)
                .image(image)
                .tag(tag)
                .build();
    }
}

