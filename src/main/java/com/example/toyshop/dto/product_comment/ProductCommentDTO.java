package com.example.toyshop.dto.product_comment;

import com.example.toyshop.dto.user.UserDTO;
import lombok.Data;

@Data
public class ProductCommentDTO {
    private Long id;
    private String comment;
    private Float rating;
    private UserDTO author;
}
