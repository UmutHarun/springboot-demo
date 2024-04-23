package com.aquweak.demo.Product.queryhandlers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aquweak.demo.Query;
import com.aquweak.demo.Exceptions.ProductNotFoundException;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;


@Service
public class GetProductQueryHandler implements Query<Integer , Product>{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Product> execute(Integer id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isEmpty()){
            throw new ProductNotFoundException();
        }

        // ProductDTO productDTO = new ProductDTO(product.get());
        
        return ResponseEntity.ok(product.get());
    }
}
