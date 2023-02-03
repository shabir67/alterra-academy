package com.jwt.task.service;

import com.jwt.task.entity.UserEntity;
import com.jwt.task.service.in.GetAllUserUseCase;
import com.jwt.task.service.out.GetAllUserPort;
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
