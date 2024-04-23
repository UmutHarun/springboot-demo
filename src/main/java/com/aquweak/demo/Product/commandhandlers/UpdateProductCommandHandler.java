package com.aquweak.demo.Product.commandhandlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aquweak.demo.Command;
import com.aquweak.demo.Exceptions.ProductNotFoundException;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;
import com.aquweak.demo.Product.Model.UpdateProductCommand;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand , ResponseEntity>{

    @Autowired
    private ProductRepository productRepository;

    @CacheEvict(value = "productCache" , key = "#entity.getId()")
    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateProductCommand entity) {
        Optional<Product> optionalProduct = productRepository.findById(entity.getId());

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException();
        }

        Product product = entity.getProduct();
        product.setId(entity.getId());
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
    
}
