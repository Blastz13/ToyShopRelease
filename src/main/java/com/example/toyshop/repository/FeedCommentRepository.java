package com.example.toyshop.repository;

import com.example.toyshop.entity.FeedComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedCommentRepository extends JpaRepository<FeedComment, Long> {
    List<FeedComment> findAllByFeedId(Long id);
}
