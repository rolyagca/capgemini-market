package com.capgemini.market.domain.service;

import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(Integer productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(Integer categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public  Product save(Product product){
        return productRepository.save(product);
    }

    public  boolean delete(Integer productId){
        return getProduct(productId).map(product -> {
           productRepository.delete(productId);
           return true;
        }).orElse(false);
        /*
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        } */
    }

    public Optional<Product> updateNameProduct(String name, Integer productId){
        return productRepository.updateNameProduct(name, productId).map(a -> {
             return getProduct(productId);
        }).orElseGet(null);
    }

}
