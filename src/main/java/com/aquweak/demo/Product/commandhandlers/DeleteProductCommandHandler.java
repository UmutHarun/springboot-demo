package com.aquweak.demo.Product.commandhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aquweak.demo.Command;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;

@Service
public class DeleteProductCommandHandler implements Command<Integer,ResponseEntity>{

    @Autowired ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(Integer id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
    
}
