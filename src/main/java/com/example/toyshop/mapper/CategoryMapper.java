package com.example.toyshop.mapper;

import com.example.toyshop.dto.category.CategoryCreateDTO;
import com.example.toyshop.dto.category.CategoryListDTO;
import com.example.toyshop.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryCreateDTO categoryCreateDTO);

    CategoryCreateDTO toDto(Category category);

    CategoryListDTO toListDto(Category category);
}
