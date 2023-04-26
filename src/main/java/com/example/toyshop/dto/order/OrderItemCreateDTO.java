package com.example.toyshop.dto.order;

import lombok.Data;

@Data
public class OrderItemCreateDTO {
    private Short quantity;
    private Long productId;
}
