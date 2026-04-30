package com.hospitalmanagement.config;

import com.hospitalmanagement.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/auth/**").permitAll()
                                //.requestMatchers("/patients/**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .sessionManagement(
                        sessionConfig ->
                        sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
               // .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService myInMemoryUserDetailsService(){
//        UserDetails normalUser =
//                User.withUsername("satish")
//                        .password(passwordEncoder()
//                                .encode("password"))
//                        .roles("USER")
//                        .build();
//        UserDetails adminUser =
//                User.withUsername("lovely")
//                        .password(passwordEncoder()
//                                .encode("password"))
//                        .roles("ADMIN")
//                        .build();
//        return new InMemoryUserDetailsManager(normalUser, adminUser);
//    }



    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config){
        return config.getAuthenticationManager();
    }

}
