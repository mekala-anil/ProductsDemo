package com.anil.ProductsDemo.repositary;

import com.anil.ProductsDemo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositary extends JpaRepository<Product, Integer>
{
    Product findById(int id);

    @Query(value = "select * from product where mrp>?1", nativeQuery = true)
    List<Product>findByPrice(double mrp);
}
