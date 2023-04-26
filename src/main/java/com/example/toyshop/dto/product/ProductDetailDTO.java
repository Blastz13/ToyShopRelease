package com.example.toyshop.dto.product;

import com.example.toyshop.dto.category.CategoryProductDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductDetailDTO {
    private Long id;
    private String title;
    private Float price;
    private Short amount;
    private String description;
    private Float rating;
    private CategoryProductDTO category;
    private List<ProductImageDTO> images;
    private List<ProductCommentDTO> comments;
    private Float new_price;
    private Float discount;
    private Long delivery_period;
}
