package com.example.apartementapi.security;

import com.example.apartementapi.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Slf4j
public class SecurityConf extends WebSecurityConfigurerAdapter {

    private CustomAuthenticationProvider authProvider ;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.warn("pass for test = "+new BCryptPasswordEncoder().encode("test"));
        auth.authenticationProvider(authProvider) ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").anonymous()
                .antMatchers(HttpMethod.GET, "/ping").anonymous()
                .antMatchers(HttpMethod.GET, "/houses").anonymous()
                .antMatchers(HttpMethod.POST,"/houses").anonymous()
                .antMatchers(HttpMethod.PUT,"/houses").anonymous()
                .antMatchers("/category").anonymous()
                .antMatchers("/city").anonymous()
                .antMatchers(HttpMethod.GET,"/history").anonymous()
                .antMatchers(HttpMethod.PUT,"/history").anonymous()
                .antMatchers(HttpMethod.GET).anonymous()
                .antMatchers(HttpMethod.GET, "/users").anonymous()
                .antMatchers(HttpMethod.GET, "/users/*").anonymous()
                .antMatchers(HttpMethod.POST, "/users").anonymous()
                .antMatchers(HttpMethod.PUT).anonymous()
                .and()
                .cors()
                .and()
                .formLogin().disable()
                .logout().disable()
                .csrf().disable()
                .httpBasic();
    }
}
