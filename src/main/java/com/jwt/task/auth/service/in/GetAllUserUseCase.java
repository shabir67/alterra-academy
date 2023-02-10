package com.jwt.task.auth.service.in;

import com.jwt.task.auth.entity.UserEntity;

import java.util.List;

public interface GetAllUserUseCase {

    List<UserEntity> getAllUser();
}
