package com.example.SpringDataSecurity.repository;

import com.example.SpringDataSecurity.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Page<Order> findByPriceGreaterThan(double price, Pageable pageable);

}
