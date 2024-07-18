package com.java.semester2finalyear3api.repository;

import com.java.semester2finalyear3api.api.models.CustomersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomersModel, Integer> {
}
