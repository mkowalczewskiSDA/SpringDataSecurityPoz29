package com.example.SpringDataSecurity.repository;

import com.example.SpringDataSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
