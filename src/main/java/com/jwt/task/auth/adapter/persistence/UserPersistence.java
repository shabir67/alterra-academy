package com.jwt.task.auth.adapter.persistence;

import com.jwt.task.auth.config.JwtService;
import com.jwt.task.auth.entity.Role;
import com.jwt.task.auth.entity.UserEntity;
import com.jwt.task.auth.service.out.CreateUserPort;
import com.jwt.task.auth.service.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserPersistence implements CreateUserPort, GetAllUserPort {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public UserEntity createUser(UserEntity userEntity) {
        var user = UserEntity.builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .password(passwordEncoder.encode(userEntity.getPassword()))
                .role(Role.USER)
                .build();
        return userRepository.save(user);
    }



}
