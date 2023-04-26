package com.example.toyshop.controller;

import com.example.toyshop.dto.feed_comment.FeedCommentCreateDTO;
import com.example.toyshop.dto.feed_comment.FeedCommentDetailDTO;
import com.example.toyshop.dto.feed_comment.FeedCommentListDTO;
import com.example.toyshop.service.FeedCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed/{fid}/comments")
@AllArgsConstructor
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping("/")
    public ResponseEntity<FeedCommentDetailDTO> create(@RequestBody FeedCommentCreateDTO dto, @PathVariable Long fid) {
        return ResponseEntity.ok(service.create(dto, fid));
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeedCommentListDTO>> getAllFeedComments(@PathVariable Long fid) {
        return ResponseEntity.ok(service.findAllByFeedId(fid));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
