package com.example.toyshop.mapper;

import com.example.toyshop.dto.feed_category.FeedCategoryCreateDTO;
import com.example.toyshop.dto.feed_category.FeedCategoryListDTO;
import com.example.toyshop.entity.FeedCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedCategoryMapper {
    FeedCategory fromCreateDto(FeedCategoryCreateDTO dto);

    FeedCategoryCreateDTO toCreateDto(FeedCategory category);

    FeedCategoryListDTO toListDto(FeedCategory category);
}
