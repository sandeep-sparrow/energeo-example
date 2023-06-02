package com.project.energeo.configuration;


import com.project.energeo.model.User;
import com.project.energeo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = iUserRepository.findUserByName(username);

        return user.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found " + username));
    }
}
