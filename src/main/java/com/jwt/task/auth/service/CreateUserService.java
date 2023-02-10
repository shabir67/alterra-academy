package com.jwt.task.auth.service;

import com.jwt.task.auth.entity.UserEntity;
import com.jwt.task.auth.service.in.CreateUserUseCase;
import com.jwt.task.auth.service.out.CreateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return createUserPort.createUser(userEntity);
    }
}
