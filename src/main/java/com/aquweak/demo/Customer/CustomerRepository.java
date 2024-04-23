package com.aquweak.demo.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquweak.demo.Customer.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

} 
