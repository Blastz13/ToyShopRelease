package com.example.toyshop.controller;

import com.example.toyshop.dto.feed_category.FeedCategoryCreateDTO;
import com.example.toyshop.dto.feed_category.FeedCategoryListDTO;
import com.example.toyshop.service.FeedCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed_category")
@RequiredArgsConstructor
public class FeedCategoryController {
    private final FeedCategoryService service;

    @PostMapping("/")
    public ResponseEntity<FeedCategoryListDTO> create(@RequestBody FeedCategoryCreateDTO category) {
        return ResponseEntity.ok(service.create(category));
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeedCategoryListDTO>> getFeedCategoryList() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
