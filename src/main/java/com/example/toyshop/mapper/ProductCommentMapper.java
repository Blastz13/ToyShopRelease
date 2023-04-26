package com.example.toyshop.mapper;

import com.example.toyshop.dto.product_comment.ProductCommentCreateDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDetailDTO;
import com.example.toyshop.entity.ProductComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCommentMapper {
    ProductComment toEntity(ProductCommentDTO dto);

    ProductCommentDTO toDto(ProductComment comment);

    ProductComment fromCreateDto(ProductCommentCreateDTO dto);

    ProductCommentDetailDTO toDetailDto(ProductComment comment);
}
