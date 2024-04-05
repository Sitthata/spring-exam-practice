package com.example.springexampractice.controller;

import com.example.springexampractice.model.dto.PageDTO;
import com.example.springexampractice.model.dto.ProductDTO;
import com.example.springexampractice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<PageDTO<ProductDTO>> get(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }
}
