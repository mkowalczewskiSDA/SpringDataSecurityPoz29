package com.example.SpringDataSecurity.service;

import com.example.SpringDataSecurity.model.Order;
import com.example.SpringDataSecurity.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Page<Order> getOrdersPaginated(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
