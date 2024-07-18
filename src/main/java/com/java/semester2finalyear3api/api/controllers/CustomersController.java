package com.java.semester2finalyear3api.api.controllers;

import com.java.semester2finalyear3api.api.models.CustomersModel;
import com.java.semester2finalyear3api.dto.CustomerRequest;
import com.java.semester2finalyear3api.services.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping()
    public List<CustomersModel> getCustomers() {
        return this.customerService.getCustomers();
    }

    @GetMapping("{id}")
    public CustomersModel getCustomer(@PathVariable int id) {
        return this.customerService.getCustomer(id);
    }

    @PostMapping()
    public void createCustomer(@RequestBody CustomerRequest customerRequest) {
        this.customerService.createCustomer(customerRequest);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody CustomerRequest customerRequest) {
        this.customerService.updateCustomer(id, customerRequest);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable int id) {
        this.customerService.deleteCustomer(id);
    }
}
