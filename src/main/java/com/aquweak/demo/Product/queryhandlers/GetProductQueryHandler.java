package com.aquweak.demo.Product.queryhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aquweak.demo.Query;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;

@Service
public class GetProductQueryHandler implements Query<Integer , Product>{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Product> execute(Integer id) {
        return ResponseEntity.ok(productRepository.findById(id).get());
    }
}
