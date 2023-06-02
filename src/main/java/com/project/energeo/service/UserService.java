package com.project.energeo.service;

import com.project.energeo.model.User;
import com.project.energeo.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;

    public String addUser(User user){
        user.setCompanyId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        try{
            iUserRepository.save(user);
            return "User Information Added to System!";
        }catch (Exception exc){
            throw new RuntimeException(exc);
        }
    }

}
