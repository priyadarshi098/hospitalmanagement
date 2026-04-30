package com.hospitalmanagement.service;

import com.hospitalmanagement.dto.SignUpDto;
import com.hospitalmanagement.dto.UserDto;
import com.hospitalmanagement.entity.Users;
import com.hospitalmanagement.exception.ResourceNotFoundException;
import com.hospitalmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordencoder;

    @Override
    public UserDetails loadUserByUsername(
            String username) throws UsernameNotFoundException {
        try {
            return userRepository.findByEmail(username)
                    .orElseThrow(
                            () -> new ResourceNotFoundException(
                                    "user not found with email id :"+username));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Users getUserById(Long id) throws ResourceNotFoundException {
         return userRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "user not found with user id :"+id));
    }

    public UserDto signUp(SignUpDto signupdto){
        Optional<Users> user =
                userRepository.findByEmail(signupdto.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("user already there");
        }
        Users toBeCreatedUser = modelMapper.map(signupdto, Users.class);
        toBeCreatedUser.setPassword(passwordencoder.encode(toBeCreatedUser.getPassword()));
        Users saveduser = userRepository.save(toBeCreatedUser);
        return modelMapper.map(saveduser, UserDto.class);
    }


}
