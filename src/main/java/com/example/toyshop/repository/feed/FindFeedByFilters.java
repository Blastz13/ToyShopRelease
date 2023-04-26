package com.example.toyshop.repository.feed;

import com.example.toyshop.entity.Feed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindFeedByFilters {
    List<Feed> findByFilters(String title, Long categoryId);
}
