package com.example.toyshop.controller;

import com.example.toyshop.dto.category.CategoryCreateDTO;
import com.example.toyshop.dto.category.CategoryListDTO;
import com.example.toyshop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/")
    public ResponseEntity<CategoryListDTO> create(@RequestBody CategoryCreateDTO category){
        return ResponseEntity.ok(service.create(category));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoryListDTO>> getCategoryList() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

