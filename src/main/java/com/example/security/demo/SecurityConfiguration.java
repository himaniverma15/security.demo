package com.example.security.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//               // .antMatchers(HttpMethod.GET,"/hello").permitAll()
//                .antMatchers(HttpMethod.POST, "/user").permitAll()
//                .anyRequest().authenticated();


        http.cors().and().csrf().disable()
                        .authorizeRequests()
                        .antMatchers().hasRole("")
                        .antMatchers().hasRole("")
                        .antMatchers().hasAuthority("")
                        .anyRequest().authenticated();
       
        http.csrf().disable()
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
              //  .antMatchers(HttpMethod.GET,"/hello").permitAll()
                .anyRequest().authenticated();
    }

}
