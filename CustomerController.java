package com.exercise.customerapi.controller;



import com.exercise.customerapi.model.Customer;
import com.exercise.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{phonenumber}")
    public ResponseEntity<Customer> getCustomerByPhonenumber(@PathVariable String phonenumber) {
        Optional<Customer> customer = customerRepository.findByCusPhonenumber(phonenumber);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setCusFirstName(customerDetails.getCusFirstName());
            customer.setCusLastName(customerDetails.getCusLastName());
            customer.setCusPhonenumber(customerDetails.getCusPhonenumber());
            return ResponseEntity.ok(customerRepository.save(customer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
