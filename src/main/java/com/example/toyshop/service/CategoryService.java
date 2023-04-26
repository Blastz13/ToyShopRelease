package com.example.toyshop.service;

import com.example.toyshop.dto.category.CategoryCreateDTO;
import com.example.toyshop.dto.category.CategoryListDTO;
import com.example.toyshop.entity.Category;
import com.example.toyshop.repository.CategoryRepository;
import com.example.toyshop.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private CategoryMapper mapper;


    public CategoryListDTO create(CategoryCreateDTO CategoryCreateDTO) {
        return mapper.toListDto(repository.save(mapper.toEntity(CategoryCreateDTO)));
    }

    public List<CategoryListDTO> findAll() {
        return repository.findAll().stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public List<CategoryCreateDTO> findByTitle(String title) {
        return repository.findByTitle(title).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public Category findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Category update(Category Category) {
        return repository.save(Category);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Category readById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found - " + id));
    }
}
