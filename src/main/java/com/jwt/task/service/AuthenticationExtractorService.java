package com.jwt.task.service;

import com.jwt.task.config.JwtService;
import com.jwt.task.entity.ExtractorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationExtractorService {
    private final JwtService jwtService;

    public ExtractorResponse extractToken(@NonNull HttpServletRequest request){
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userPhone;
        jwt = authHeader.substring(7);
        userPhone = jwtService.extractUsername(jwt);
        return ExtractorResponse.builder()
                .endResult(userPhone)
                .build();
    }
}
