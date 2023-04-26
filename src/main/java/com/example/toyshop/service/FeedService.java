package com.example.toyshop.service;

import com.example.toyshop.dto.feed.FeedCreateDTO;
import com.example.toyshop.dto.feed.FeedListDTO;
import com.example.toyshop.entity.Feed;
import com.example.toyshop.entity.FeedCategory;
import com.example.toyshop.entity.User;
import com.example.toyshop.repository.feed.FeedRepository;
import com.example.toyshop.mapper.FeedMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeedService {
    private final FeedRepository repository;
    private final UserService userService;
    private final FeedCategoryService feedCategoryService;
    private FeedMapper mapper;


    public FeedListDTO create(FeedCreateDTO dto) {
        User author = userService.findById(dto.getAuthorId());
        FeedCategory category = feedCategoryService.findById(dto.getCategoryId());
        Feed feed = mapper.fromCreateDto(dto);
        feed.setAuthor(author);
        feed.setCategory(category);
        return mapper.toListDto(repository.save(feed));
    }

    public List<FeedListDTO> findAll(String title, Long category) {
        return repository.findByFilters(title, category).stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public List<FeedListDTO> findAllByUserId(Long id) {
        return repository.findAllByAuthorId(id).stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public FeedListDTO findById(Long id){
        return mapper.toListDto(repository.findById(id).orElse(null));
    }

    public Feed findByIdEntity(Long id){
        return repository.findById(id).orElse(null);
    }

    public Feed update(Feed feed) {
        return repository.save(feed);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
