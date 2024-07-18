package com.java.semester2finalyear3api.services;

import com.java.semester2finalyear3api.api.models.CustomersModel;
import com.java.semester2finalyear3api.dto.CustomerRequest;
import com.java.semester2finalyear3api.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomersModel> getCustomers() {
        return this.customerRepository.findAll();
    }

    public CustomersModel getCustomer(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    public void createCustomer(CustomerRequest customerRequest) {

        this.customerRepository.save(
                CustomersModel.builder()
                        .firstname(customerRequest.getFirstname())
                        .lastname(customerRequest.getLastname())
                        .phone(customerRequest.getPhone())
                        .build()
        );

    }

    public void updateCustomer(int id, CustomerRequest customerRequest) {
        Optional<CustomersModel> customersModel = this.customerRepository.findById(id);

        if (customersModel.isPresent()) {
            customersModel.get().setFirstname(customerRequest.getFirstname());
            customersModel.get().setLastname(customerRequest.getLastname());
            customersModel.get().setPhone(customerRequest.getPhone());

            this.customerRepository.save(customersModel.get());
        }
    }

    public void deleteCustomer(int id) {
        this.customerRepository.deleteById(id);
    }
}
