package com.aquweak.demo.Product.queryhandlers;

import com.aquweak.demo.Product.Model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aquweak.demo.Query;
import com.aquweak.demo.Product.ProductRepository;


@Service
public class GetAllProductsQueryHandler implements Query<Void, List<Product>>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<Product>> execute(Void input) {
        return ResponseEntity.ok(productRepository.findAll());
    }
    
}
