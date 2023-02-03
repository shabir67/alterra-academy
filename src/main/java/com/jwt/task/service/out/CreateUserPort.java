package com.jwt.task.service.out;

import com.jwt.task.entity.UserEntity;

public interface CreateUserPort {

    UserEntity createUser(UserEntity userEntity);
}
