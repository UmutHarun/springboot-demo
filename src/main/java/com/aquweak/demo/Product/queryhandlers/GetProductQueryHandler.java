package com.aquweak.demo.Product.queryhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aquweak.demo.Query;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.ProductDTO;

@Service
public class GetProductQueryHandler implements Query<Integer , ProductDTO>{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductDTO> execute(Integer id) {
        ProductDTO productDTO = new ProductDTO(productRepository.findById(id).get());
        return ResponseEntity.ok(productDTO);
    }
}
