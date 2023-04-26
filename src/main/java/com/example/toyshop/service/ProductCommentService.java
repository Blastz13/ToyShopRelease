package com.example.toyshop.service;

import com.example.toyshop.dto.product_comment.ProductCommentCreateDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDetailDTO;
import com.example.toyshop.entity.Product;
import com.example.toyshop.entity.ProductComment;
import com.example.toyshop.entity.User;
import com.example.toyshop.repository.product_comment.ProductCommentRepository;
import com.example.toyshop.mapper.ProductCommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductCommentService {
    private final ProductCommentRepository repository;
    private final UserService userService;
    private final ProductService productService;
    private ProductCommentMapper mapper;

    public ProductCommentDetailDTO create(ProductCommentCreateDTO dto, Long productId) {
        User author = userService.findById(dto.getAuthorId());
        ProductComment comment = mapper.fromCreateDto(dto);
        comment.setAuthor(author);
        Product product = productService.findById(productId);
        comment.setProduct(product);
        return mapper.toDetailDto(repository.save(comment));
    }

    public List<ProductCommentDTO> findAll(Long productId, Float min_rating, Float max_rating) {
        return repository.findByFilters(productId, min_rating, max_rating).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
