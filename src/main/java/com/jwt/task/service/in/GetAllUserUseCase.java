package com.jwt.task.service.in;

import com.jwt.task.entity.UserEntity;

import java.util.List;

public interface GetAllUserUseCase {

    List<UserEntity> getAllUser();
}
