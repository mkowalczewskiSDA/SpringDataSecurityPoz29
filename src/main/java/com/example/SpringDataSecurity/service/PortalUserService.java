package com.example.SpringDataSecurity.service;

import com.example.SpringDataSecurity.model.PortalUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortalUserService {

    Page<PortalUser> findAllPaginated(Pageable pageable);

}
