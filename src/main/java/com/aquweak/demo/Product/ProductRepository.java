package com.aquweak.demo.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquweak.demo.Product.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
