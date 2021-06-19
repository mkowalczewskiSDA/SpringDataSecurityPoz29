package com.example.SpringDataSecurity.service;

import com.example.SpringDataSecurity.model.PortalUser;
import com.example.SpringDataSecurity.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PortalUserServiceImpl implements PortalUserService {

    final private UserRepository userRepository;

    public PortalUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PortalUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Page<PortalUser> findAllPaginated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<PortalUser> findByLastNameBeginsWith(String lastName, Pageable pageable) {
        return userRepository.findByLastNameStartsWith(lastName, pageable);
    }

}
