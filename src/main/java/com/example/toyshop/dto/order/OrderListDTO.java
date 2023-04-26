package com.example.toyshop.dto.order;

import com.example.toyshop.dto.user.UserDTO;
import com.example.toyshop.entity.OrderStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderListDTO {
    private Long id;
    private String address;
    private Date creationDate;
    private String phone;
    private UserDTO buyer;
    private List<OrderItemListDTO> orderItems;
    private OrderStatus status;
    private Float total;
}
