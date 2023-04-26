package com.example.toyshop.mapper;

import com.example.toyshop.dto.order.OrderItemCreateDTO;
import com.example.toyshop.dto.order.OrderItemListDTO;
import com.example.toyshop.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem toEntity(OrderItemCreateDTO dto);

    OrderItemCreateDTO toDto(OrderItem orderItem);

    OrderItemListDTO toListDto(OrderItem orderItem);
}
