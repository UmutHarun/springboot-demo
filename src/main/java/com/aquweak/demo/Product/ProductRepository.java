package com.aquweak.demo.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aquweak.demo.Product.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
