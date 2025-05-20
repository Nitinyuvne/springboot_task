package com.example.crudapp.service;

import com.example.crudapp.model.Customer;
import com.example.crudapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> listAll() {
        return repo.findAll();
    }

    public void save(Customer customer) {
        repo.save(customer);
    }

    public Customer get(Long id) {
        Optional<Customer> result = repo.findById(id);
        return result.orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
