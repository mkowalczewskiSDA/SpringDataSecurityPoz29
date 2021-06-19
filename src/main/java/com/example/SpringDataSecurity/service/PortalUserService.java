package com.example.SpringDataSecurity.service;

import com.example.SpringDataSecurity.model.PortalUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortalUserService {

    PortalUser findByLogin(String login);

    Page<PortalUser> findAllPaginated(Pageable pageable);

    Page<PortalUser> findByLastNameBeginsWith(String lastName, Pageable pageable);

    void save(PortalUser portalUser);

}
