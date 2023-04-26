package com.example.toyshop.dto.product_comment;

import com.example.toyshop.dto.product.ProductCategoryDTO;
import com.example.toyshop.dto.user.UserDTO;
import lombok.Data;

@Data
public class ProductCommentDetailDTO {
    private Long id;
    private String comment;
    private Float rating;
    private UserDTO author;
    private ProductCategoryDTO product;
}
