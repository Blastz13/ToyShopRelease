package com.example.toyshop.mapper;

import com.example.toyshop.dto.feed_comment.FeedCommentCreateDTO;
import com.example.toyshop.dto.feed_comment.FeedCommentDetailDTO;
import com.example.toyshop.dto.feed_comment.FeedCommentListDTO;
import com.example.toyshop.entity.FeedComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedCommentMapper {
    FeedComment fromCreateDto(FeedCommentCreateDTO dto);
    FeedCommentDetailDTO toDetailDto(FeedComment dto);
    FeedCommentListDTO toListDto(FeedComment dto);
}
