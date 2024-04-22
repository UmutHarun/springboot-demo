package com.aquweak.demo.Product.Model;


public class ProductDTO {
    private String name;
    private String description;
    private Double price;

    public ProductDTO(Product product){
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    public Product toProduct() {
        Product product = new Product();
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        return product;
    }
}
