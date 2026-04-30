package com.hospitalmanagement.service;

import com.hospitalmanagement.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersServicetest {

    @Autowired
    private JwtService jwtService;

  //  @Test
//    public void test_test(){
////        Users user = new Users(
////                4L,
////                "anuj@gmail.com",
////                "1234");
////        String token = jwtService.generateAccessToken(user);
////        System.out.println(token);
////        Long id = jwtService.getUserIdFromToken(token);
////        System.out.println(id);
//    }
}
