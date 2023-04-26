package com.example.toyshop.mapper;

import com.example.toyshop.dto.product.ProductCategoryDTO;
import com.example.toyshop.dto.product.ProductCreateDTO;
import com.example.toyshop.dto.product.ProductDetailDTO;
import com.example.toyshop.dto.product.ProductListDTO;
import com.example.toyshop.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntityFromDetailDto(ProductDetailDTO dto);

    ProductDetailDTO toDetailDto(Product product);

    ProductCategoryDTO toCategoryDto(Product product);

    ProductListDTO toListDto(Product product);

    Product fromCreateDto(ProductCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product update(ProductCreateDTO dto, @MappingTarget Product product);
}
