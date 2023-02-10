package com.jwt.task.auth.adapter.controller;

import com.jwt.task.auth.entity.UserEntity;
import com.jwt.task.auth.service.in.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class GetAllUserController {

    private final GetAllUserUseCase getAllUserUseCase;

    @GetMapping
    public List<UserEntity> getAllUser () {
        return getAllUserUseCase.getAllUser();
    }

}
