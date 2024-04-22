package com.aquweak.demo.Product.commandhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aquweak.demo.Command;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;
import com.mysql.cj.util.StringUtils;

@Service
public class CreateProductCommandHandler implements Command<Product,ResponseEntity>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(Product entity) {

        validateProduct(entity);

        productRepository.save(entity);
        return ResponseEntity.ok().build();
        
    }
    
    private void validateProduct(Product product){

        if(io.micrometer.common.util.StringUtils.isBlank(product.getName())){
            throw new RuntimeException("Product name cannot be empty");
        }
        if(io.micrometer.common.util.StringUtils.isBlank(product.getDescription())){
            throw new RuntimeException("Description name cannot be empty");
        }
        if(product.getPrice() <= 0.0){
            throw new RuntimeException("Product name cannot be negative number");
        }
        if(product.getQuantity() < 0){
            throw new RuntimeException("Product name cannot be negative number");
        }

    }
}
