package com.example.toyshop.service;

import com.example.toyshop.dto.product.ProductCreateDTO;
import com.example.toyshop.dto.product.ProductDetailDTO;
import com.example.toyshop.dto.product.ProductImageDTO;
import com.example.toyshop.dto.product.ProductListDTO;
import com.example.toyshop.entity.Category;
import com.example.toyshop.entity.Product;
import com.example.toyshop.entity.ProductImage;
import com.example.toyshop.repository.product.ProductRepository;
import com.example.toyshop.mapper.ProductImageMapper;
import com.example.toyshop.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductImageService productImageService;
    private ProductMapper productMapper;
    private ProductImageMapper productImageMapper;

    public ProductDetailDTO create(ProductCreateDTO dto, MultipartFile file) throws IOException {
        Product product = productMapper.fromCreateDto(dto);
        productRepository.save(product);
        if (dto.getCategoryId() != null) {
            Category category = categoryService.findById(dto.getCategoryId());
            product.setCategory(category);
        }
        if (file != null)
            product.addImage(productImageService.create(file, product));
        return productMapper.toDetailDto(productRepository.save(product));
    }

    public List<ProductListDTO> findAll(String title, Long categoryId, Float min_price, Float max_price,
                                        Short delivery_period, Float discount, Float min_rating, Float max_rating) {
        return productRepository.findByFilters(title, categoryId, min_price, max_price, delivery_period, discount,
                        min_rating, max_rating)
                .stream().map(productMapper::toListDto).collect(Collectors.toList());
    }

    public ProductDetailDTO findByIdDto(Long id) {
        return productMapper.toDetailDto(productRepository.findById(id).orElse(null));
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductDetailDTO update(Long id, ProductCreateDTO dto) {
        return productMapper.toDetailDto(productRepository.save(productMapper.update(dto, this.findById(id))));
    }

    public ProductImageDTO addImage(Long productId, MultipartFile file) throws IOException {
        try {
            Product product = findById(productId);
            if (file != null) {
                ProductImage image = productImageService.create(file, product);
                product.addImage(image);
                return productImageMapper.toDto(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public void delete(Long id) {
        findById(id).getImages().forEach(productImage -> {
            try {
                productImageService.delete(productImage.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        productRepository.deleteById(id);
    }
}
