package com.aquweak.demo.Product.queryhandlers;

import com.aquweak.demo.Product.Model.Product;
import com.aquweak.demo.Product.Model.ProductDTO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aquweak.demo.Query;
import com.aquweak.demo.Product.ProductRepository;


@Service
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDTO>>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<ProductDTO> productDTOs = productRepository.findAll().stream().map(product -> new ProductDTO(product)).toList();

        return ResponseEntity.ok(productDTOs);
    }
    
}
