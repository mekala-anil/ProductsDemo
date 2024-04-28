package com.anil.ProductsDemo.service;

import com.anil.ProductsDemo.Entity.Product;
import com.anil.ProductsDemo.repositary.ProductRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepositary productsRepo;

    public List<Product>getALl(){
        List<Product>list=productsRepo.findAll();
        return list;
    }

    public String insert(Product product){
        productsRepo.save(product);
        return "Inserted";
    }

    public String delete(int id){
        productsRepo.deleteById(id);
        return "Deleted";
    }

    public String update(Product product){
        Product tmp=productsRepo.findById(product.getId());
        if(product.getName()!=null){
            tmp.setName(product.getName());
        }
        if(product.getMrp()!=0.0){
            tmp.setMrp(product.getMrp());
        }
        productsRepo.save(tmp);
        return "Updated";
    }

    public List<Product>getByPrice(double mrp){

        return productsRepo.findByPrice(mrp);
    }
}
