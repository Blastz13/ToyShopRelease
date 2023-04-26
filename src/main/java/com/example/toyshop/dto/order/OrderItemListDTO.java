package com.example.toyshop.dto.order;

import com.example.toyshop.dto.product.ProductCategoryDTO;
import lombok.Data;

@Data
public class OrderItemListDTO {
    private Long id;
    private Short quantity;
    private ProductCategoryDTO product;
}
