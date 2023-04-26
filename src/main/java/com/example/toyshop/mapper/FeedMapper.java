package com.example.toyshop.mapper;

import com.example.toyshop.dto.feed.FeedCreateDTO;
import com.example.toyshop.dto.feed.FeedListDTO;
import com.example.toyshop.entity.Feed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedMapper {
    Feed fromCreateDto(FeedCreateDTO dto);
    FeedListDTO toListDto(Feed feed);
}
