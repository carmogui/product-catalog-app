package com.personal.productcatalog.service;

import com.personal.productcatalog.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getCurrentUser() {
        // TODO
        // ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClaims()
        // name
        // email

        SecurityContextHolder.getContext().getAuthentication();

        return new User();
    }
}
