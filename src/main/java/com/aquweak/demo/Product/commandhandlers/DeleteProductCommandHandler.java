package com.aquweak.demo.Product.commandhandlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aquweak.demo.Command;
import com.aquweak.demo.Exceptions.ProductNotFoundException;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;

@Service
public class DeleteProductCommandHandler implements Command<Integer,ResponseEntity>{

    @Autowired ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(Integer id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException();
        }

        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
    
}
