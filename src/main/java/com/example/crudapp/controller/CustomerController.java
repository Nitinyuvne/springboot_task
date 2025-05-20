package com.example.crudapp.controller;

import com.example.crudapp.model.Customer;
import com.example.crudapp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // List all customers
    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", service.listAll());
        return "customers";  // thymeleaf view "customers.html"
    }

    // Show form to add new customer
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer_form";  // thymeleaf view "customer_form.html"
    }

    // Save new customer
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        service.save(customer);
        return "redirect:/customers";
    }

    // Show form to edit existing customer
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Customer customer = service.get(id);
        model.addAttribute("customer", customer);
        return "customer_form";
    }

    // Delete customer
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/customers";
    }
}
