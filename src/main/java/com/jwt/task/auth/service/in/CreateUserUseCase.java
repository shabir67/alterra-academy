package com.jwt.task.auth.service.in;

import com.jwt.task.auth.entity.UserEntity;

public interface CreateUserUseCase {
    UserEntity createUser(UserEntity userEntity);
}
