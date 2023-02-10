package com.jwt.task.auth.service;

import com.jwt.task.auth.entity.UserEntity;
import com.jwt.task.auth.service.in.GetAllUserUseCase;
import com.jwt.task.auth.service.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {

    private final GetAllUserPort getAllUserPort;

    @Override
    public List<UserEntity> getAllUser() {
        return getAllUserPort.getAllUser();
    }
}
