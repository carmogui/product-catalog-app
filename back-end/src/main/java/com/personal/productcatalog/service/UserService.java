package com.personal.productcatalog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.productcatalog.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    public User getCurrentUser() {
        Map<String, Object> claims = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClaims();

        Map<String, Object> userClaims = claims.entrySet().stream()
                .filter(this::containsInUserClass)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(userClaims, User.class);
    }

    private boolean containsInUserClass(Map.Entry<String, Object> entry) {
        List<String> fields = Arrays.stream(User.class.getDeclaredFields())
                .map(Field::getName)
                .toList();
        String key = entry.getKey();

        return fields.stream()
                .anyMatch(field -> field.equals(key));
    }
}
