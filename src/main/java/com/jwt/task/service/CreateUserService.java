package com.jwt.task.service;

import com.jwt.task.entity.UserEntity;
import com.jwt.task.service.in.CreateUserUseCase;
import com.jwt.task.service.out.CreateUserPort;
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
