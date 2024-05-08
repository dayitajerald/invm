package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Product;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findById(int id);

    List<Product> findByQuantity(int quantity);

    @Modifying
    @Query("update Product p set p.quantity=?1 where p.id=?2")
    @Transactional
    void setProductById(Integer quantity, Integer id);
}
