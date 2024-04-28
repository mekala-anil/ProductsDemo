package com.anil.ProductsDemo.controller;

import com.anil.ProductsDemo.Entity.Product;
import com.anil.ProductsDemo.repositary.ProductRepositary;
import com.anil.ProductsDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    ProductService productService;

    @GetMapping("/getall")
    public List<Product> getProducts(){
        return productService.getALl();
    }
    @PostMapping("/insert")
    public String insertProduct(@RequestBody Product product){
        return productService.insert(product);
    }

    @PutMapping("/update")
    public String updateProduct(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.delete(id);
    }

    @GetMapping("/byprice/{mrp}")
    public List<Product>getByPrice(@PathVariable double mrp){
        return productService.getByPrice(mrp);
    }

}
