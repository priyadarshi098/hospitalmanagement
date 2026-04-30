package com.hospitalmanagement.filter;

import com.hospitalmanagement.entity.Users;
import com.hospitalmanagement.exception.ResourceNotFoundException;
import com.hospitalmanagement.service.JwtService;
import com.hospitalmanagement.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
        }
        String token = requestTokenHeader.split("Bearer ")[1];
        Long userId = jwtService.getUserIdFromToken(token);

        if(userId != null
                && SecurityContextHolder.getContext().getAuthentication() == null){
            try {
                Users users = userService.getUserById(userId);
                UsernamePasswordAuthenticationToken
                        usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        users,
                        null,
                        null);
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder
                        .getContext()
                        .setAuthentication(usernamePasswordAuthenticationToken);

            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
