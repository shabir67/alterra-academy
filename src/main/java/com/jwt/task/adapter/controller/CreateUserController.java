package com.jwt.task.adapter.controller;


import com.jwt.task.entity.UserEntity;
import com.jwt.task.service.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/user")
@RequiredArgsConstructor
@Slf4j
public class CreateUserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        log.info("[UBA] /createUser is called");
        return createUserUseCase.createUser(userEntity);
    }

}
