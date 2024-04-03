package com.example.springexampractice.controller;

import com.example.springexampractice.model.dto.CustomerDTO;
import com.example.springexampractice.model.dto.PageDTO;
import com.example.springexampractice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<PageDTO<CustomerDTO>> get(@RequestParam(value = "page", defaultValue = "-1") int page,
                                                    @RequestParam(value = "size", defaultValue = "-1") int size){
        return ResponseEntity.ok(customerService.getCustomers(page, size));
    }

}
