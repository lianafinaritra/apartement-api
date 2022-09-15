package com.example.apartementapi.security;

import com.example.apartementapi.model.Users;
import com.example.apartementapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Component

public class CustomAuthenticationProvider implements AuthenticationProvider {
    private UserRepository userRepository ;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString() ;
        Users user = userRepository.findByUsername(name);

        if(user != null && new BCryptPasswordEncoder().matches(password , user.getPassword())){
            return new UsernamePasswordAuthenticationToken(name, password, Arrays.asList(user.getRole()));
        }else{
            throw new BadCredentialsException("Invalid credentials, please check your password and username.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
