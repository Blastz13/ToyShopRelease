package com.example.toyshop.controller;

import com.example.toyshop.dto.product.ProductImageDTO;
import com.example.toyshop.service.ProductImageService;
import com.example.toyshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product/{pid}/images")
@RequiredArgsConstructor
public class ProductImageController {
    private final ProductService service;
    private final ProductImageService imageService;

    @PostMapping("/")
    public ResponseEntity<ProductImageDTO> addImage(@RequestPart("file") MultipartFile file,
                                                    @PathVariable Long pid) throws IOException {
        return ResponseEntity.ok(service.addImage(pid, file));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductImageDTO>> getImages(@PathVariable Long pid) {
        return ResponseEntity.ok(imageService.findAllByProductId(pid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) throws IOException {
        imageService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
