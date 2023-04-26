package com.example.toyshop.dto.category;

import com.example.toyshop.dto.product.ProductCategoryDTO;
import lombok.Data;

import java.util.List;

@Data
public class CategoryListDTO {
    private Long id;
    private String title;
    private String slug;
    private List<ProductCategoryDTO> products;
}
