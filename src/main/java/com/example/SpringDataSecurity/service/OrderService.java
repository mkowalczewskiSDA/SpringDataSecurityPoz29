package com.example.SpringDataSecurity.service;

import com.example.SpringDataSecurity.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Page<Order> getOrdersPaginated(Pageable pageable);

}
