package com.example.SpringDataSecurity.repository;
import com.example.SpringDataSecurity.model.PortalUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PortalUser, Integer> {

    PortalUser findByEmail(String email);

    Page<PortalUser> findByLastNameStartsWith(String lastName, Pageable pageable);

    PortalUser findByLogin(String login);

}
