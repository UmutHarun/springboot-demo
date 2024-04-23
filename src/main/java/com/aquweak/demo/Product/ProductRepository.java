package com.aquweak.demo.Product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquweak.demo.Product.Model.Product;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p WHERE p.description LIKE %:description")
    List<Product> customQueryMethod(@Param(value="description") String description);

    List<Product> findByDescriptionContaining(java.lang.String description);

}
