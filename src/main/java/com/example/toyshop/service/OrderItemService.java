package com.example.toyshop.service;

import com.example.toyshop.dto.order.OrderItemCreateDTO;
import com.example.toyshop.dto.order.OrderItemListDTO;
import com.example.toyshop.entity.Order;
import com.example.toyshop.entity.OrderItem;
import com.example.toyshop.repository.OrderItemRepository;
import com.example.toyshop.mapper.OrderItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository repository;
    private final ProductService productService;
    private final OrderItemMapper mapper;

    public OrderItem create(OrderItemCreateDTO dto, Order order) {
        OrderItem orderItem = mapper.toEntity(dto);
        orderItem.setProduct(productService.findById(dto.getProductId()));
        orderItem.setOrder(order);
        return repository.save(orderItem);
    }

    public List<OrderItemListDTO> findAll(){
        return repository.findAll().stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public List<OrderItemListDTO> findAllByOrderId(Long id){
        return repository.findAllByOrderId(id).stream().map(mapper::toListDto).collect(Collectors.toList());
    }
}
