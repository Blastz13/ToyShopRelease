package com.example.toyshop.mapper;

import com.example.toyshop.dto.product.ProductImageDTO;
import com.example.toyshop.entity.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImageDTO toDto(ProductImage image);
    ProductImage toEntity(ProductImageDTO dto);
}
