package com.aquweak.demo.Product;

import org.springframework.web.bind.annotation.RestController;
import com.aquweak.demo.Product.Model.Product;
import com.aquweak.demo.Product.Model.UpdateProductCommand;
import com.aquweak.demo.Product.commandhandlers.CreateProductCommandHandler;
import com.aquweak.demo.Product.commandhandlers.DeleteProductCommandHandler;
import com.aquweak.demo.Product.commandhandlers.UpdateProductCommandHandler;
import com.aquweak.demo.Product.queryhandlers.GetAllProductsQueryHandler;
import com.aquweak.demo.Product.queryhandlers.GetProductQueryHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GetAllProductsQueryHandler getAllProductsQueryHandler;

    @Autowired
    private GetProductQueryHandler getProductQueryHandler;

    @Autowired 
    private CreateProductCommandHandler createProductCommandHandler;

    @Autowired 
    private DeleteProductCommandHandler deleteProductCommandHandler;

    @Autowired
    private UpdateProductCommandHandler updateProductCommandHandler;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return getAllProductsQueryHandler.execute(null);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return getProductQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        return createProductCommandHandler.execute(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id,@RequestBody Product product){
        UpdateProductCommand command = new UpdateProductCommand(id , product);
        return updateProductCommandHandler.execute(command);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        return deleteProductCommandHandler.execute(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(value = "description") String description){
        return ResponseEntity.ok(productRepository.findByDescriptionContaining(description));
    }
}
