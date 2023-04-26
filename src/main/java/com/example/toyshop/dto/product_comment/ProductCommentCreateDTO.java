package com.example.toyshop.dto.product_comment;

import lombok.Data;

@Data
public class ProductCommentCreateDTO {
    private String comment;
    private Float rating;
    private Long authorId;
}
