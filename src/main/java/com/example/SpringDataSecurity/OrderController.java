package com.example.SpringDataSecurity;

import com.example.SpringDataSecurity.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/list")
    public String getOrders() {
        orderRepository.findAll().forEach(order -> System.out.println(order.getTitle()));
        return null;
    }

}
