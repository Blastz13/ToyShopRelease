package com.example.toyshop.service;

import com.example.toyshop.dto.feed_comment.FeedCommentCreateDTO;
import com.example.toyshop.dto.feed_comment.FeedCommentDetailDTO;
import com.example.toyshop.dto.feed_comment.FeedCommentListDTO;
import com.example.toyshop.entity.*;
import com.example.toyshop.repository.FeedCommentRepository;
import com.example.toyshop.mapper.FeedCommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeedCommentService {
    private final FeedCommentRepository repository;
    private final UserService userService;
    private final FeedService feedService;
    private FeedCommentMapper mapper;

    public FeedCommentDetailDTO create(FeedCommentCreateDTO dto, Long feedId) {
        User author = userService.findById(dto.getAuthorId());
        FeedComment comment = mapper.fromCreateDto(dto);
        comment.setAuthor(author);
        Feed feed = feedService.findByIdEntity(feedId);
        comment.setFeed(feed);
        return mapper.toDetailDto(repository.save(comment));
    }

    public List<FeedCommentListDTO> findAllByFeedId(Long id){
        return repository.findAllByFeedId(id).stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
