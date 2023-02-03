package com.jwt.task.adapter.persistence;

import com.jwt.task.config.JwtService;
import com.jwt.task.entity.Role;
import com.jwt.task.entity.UserEntity;
import com.jwt.task.service.out.CreateUserPort;
import com.jwt.task.service.out.GetAllUserPort;
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
