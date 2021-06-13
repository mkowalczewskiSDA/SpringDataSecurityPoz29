package com.example.SpringDataSecurity.controller;

import com.example.SpringDataSecurity.repository.OrderRepository;
import com.example.SpringDataSecurity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderRepository;

    @RequestMapping("/list")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderRepository.getAllOrders());
        return "index";
    }

}
