package com.project.energeo.api;

import com.project.energeo.model.AuthRequest;
import com.project.energeo.model.User;
import com.project.energeo.service.JwtService;
import com.project.energeo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }else{
            throw new UsernameNotFoundException("Invalid User request!");
        }
    }

}
