package com.peaksoft.spring_security.service;


import com.peaksoft.spring_security.entity.Product;
import com.peaksoft.spring_security.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;


    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public void save(Product product){

        repository.save(product);
    }

    public Product getById(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
        repository.deleteById(id);
    }

}
