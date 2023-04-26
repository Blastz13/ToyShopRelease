package com.example.toyshop.repository.product;

import com.example.toyshop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindProductByFilters {
    List<Product> findByFilters(String title, Long categoryId, Float min_price, Float max_price, Short delivery_period,
                                Float discount, Float min_rating, Float max_rating);
}
