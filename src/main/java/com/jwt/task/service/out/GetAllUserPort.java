package com.jwt.task.service.out;

import com.jwt.task.entity.UserEntity;

import java.util.List;

public interface GetAllUserPort {

    List<UserEntity> getAllUser();
}
