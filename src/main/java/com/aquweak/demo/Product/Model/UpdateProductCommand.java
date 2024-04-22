package com.aquweak.demo.Product.Model;
import lombok.Data;

@Data
public class UpdateProductCommand {
    private int id;
    private Product product;

    public UpdateProductCommand(int id,Product product){
        this.id = id;
        this.product = product;
    }
}
