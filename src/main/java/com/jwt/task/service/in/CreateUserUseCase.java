package com.jwt.task.service.in;

import com.jwt.task.entity.UserEntity;

public interface CreateUserUseCase {
    UserEntity createUser(UserEntity userEntity);
}
