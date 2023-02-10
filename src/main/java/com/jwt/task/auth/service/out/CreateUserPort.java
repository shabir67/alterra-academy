package com.jwt.task.auth.service.out;

import com.jwt.task.auth.entity.UserEntity;

public interface CreateUserPort {

    UserEntity createUser(UserEntity userEntity);
}
