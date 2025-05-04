package com.example.user_service.controller;

import com.example.user_service.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.example.common_lib.dto.UserDTO;
import org.example.common_lib.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class SingUpController {
    private final SignUpService signUpService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserEntity userEntity){
        try{
            UserEntity savedUser = signUpService.saveNewUser(userEntity);
            return ResponseEntity.ok(savedUser);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }



}
