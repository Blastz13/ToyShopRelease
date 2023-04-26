package com.example.toyshop.repository;

import com.example.toyshop.entity.FeedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedCategoryRepository extends JpaRepository<FeedCategory, Long> {
    List<FeedCategory> findByTitle(String title);
}
