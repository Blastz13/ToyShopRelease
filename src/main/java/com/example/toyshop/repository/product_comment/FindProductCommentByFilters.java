package com.example.toyshop.repository.product_comment;

import com.example.toyshop.entity.ProductComment;

import java.util.List;

public interface FindProductCommentByFilters {
    List<ProductComment> findByFilters(Long productId, Float min_rating, Float max_rating);
}
