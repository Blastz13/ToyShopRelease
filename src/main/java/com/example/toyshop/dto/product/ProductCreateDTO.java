package com.example.toyshop.dto.product;


import com.example.toyshop.dto.product_comment.ProductCommentDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductCreateDTO {
    private String title;
    private Float price;
    private Short amount;
    private String description;
    private Float rating;
    private Long categoryId;
    private List<ProductImageDTO> images;
    private List<ProductCommentDTO> comments;
    private Float new_price;
    private Float discount;
    private Long delivery_period;
}
