package com.example.toyshop.controller;

import com.example.toyshop.dto.feed.FeedCreateDTO;
import com.example.toyshop.dto.feed.FeedListDTO;
import com.example.toyshop.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService service;

    @PostMapping("/")
    public ResponseEntity<FeedListDTO> create(@RequestBody FeedCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeedListDTO>> getAllFeeds(@RequestParam(name = "title", required = false) String title,
                                                         @RequestParam(name = "category", required = false) Long category) {
        return ResponseEntity.ok(service.findAll(title, category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedListDTO> getFeedById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<FeedListDTO>> getAllUserFeeds(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
