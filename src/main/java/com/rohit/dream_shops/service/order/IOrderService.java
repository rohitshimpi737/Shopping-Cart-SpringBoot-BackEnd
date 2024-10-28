package com.rohit.dream_shops.service.order;

import com.rohit.dream_shops.dto.OrderDto;
import com.rohit.dream_shops.model.Order;
import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
    OrderDto convertToDto(Order order);
}
