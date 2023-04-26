package com.example.toyshop.mapper;

import com.example.toyshop.dto.order.OrderCreateDTO;
import com.example.toyshop.dto.order.OrderListDTO;
import com.example.toyshop.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order fromCreateDto(OrderCreateDTO dto);

    OrderCreateDTO toCreateDto(Order order);

    Order fromListDto(OrderListDTO dto);

    OrderListDTO toListDto(Order order);

}
