package com.example.SpringDataSecurity.repository;

import com.example.SpringDataSecurity.model.Order;
import com.example.SpringDataSecurity.model.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<PortalUser, Integer> {

    PortalUser findByEmail(String email);

}
