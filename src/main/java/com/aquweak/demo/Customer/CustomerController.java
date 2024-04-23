package com.aquweak.demo.Customer;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aquweak.demo.Customer.Model.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/customers" , method = {RequestMethod.GET , RequestMethod.POST})
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        Optional<Customer> customer = customerRepository.findById(id);
        return ResponseEntity.ok(customer.get());
    }

    @PostMapping
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok().build();
    }
    
}
