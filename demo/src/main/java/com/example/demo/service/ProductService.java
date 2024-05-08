package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<Product> listAllProducts() {
        return repo.findAll();
    }

    public List<Product> availableProducts() {
        List<Product> products = repo.findAll();
        List<Product> avaItems = new ArrayList<>();

        for (Product product : products) {
            if (product.getQuantity() > 0) {
                avaItems.add(product);
            }
        }
        return avaItems;
    }

    public void decreaseProduct(int id) {
        Product item = repo.findById(id);
        int org_quantity = item.getQuantity();
        repo.setProductById(org_quantity - 1, id);
    }

    public void saveProduct(int id, String name, int quantity) {
        Product item = new Product();
        item.setId(id);
        item.setName(name);
        item.setQuantity(quantity);
        repo.save(item);
    }

}
