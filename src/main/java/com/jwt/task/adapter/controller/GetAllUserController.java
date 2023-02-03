package com.jwt.task.adapter.controller;

import com.jwt.task.entity.UserEntity;
import com.jwt.task.service.in.GetAllUserUseCase;
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
