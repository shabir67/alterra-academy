package com.jwt.task.auth.service.out;

import com.jwt.task.auth.entity.UserEntity;

import java.util.List;

public interface GetAllUserPort {

    List<UserEntity> getAllUser();
}
