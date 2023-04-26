package com.example.toyshop.repository.feed;

import com.example.toyshop.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long>, FindFeedByFilters {
    List<Feed> findAllByAuthorId(Long id);
}
