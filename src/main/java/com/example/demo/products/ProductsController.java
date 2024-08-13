package com.example.demo.products;


import com.example.demo.products.dto.ProductFormRequest;
import com.example.demo.products.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    ProductsService service;

    @GetMapping
    public List<ProductResponse> findAll(){
        return service
                .findAll()
                .stream()
                .map(ProductResponse::fromModel)
                .toList();
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductFormRequest userForm, UriComponentsBuilder uriBuilder){
        var product = service.create(userForm.toModel());

        var uri = uriBuilder
                .path("/products/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(ProductResponse.fromModel(product));
    }

}