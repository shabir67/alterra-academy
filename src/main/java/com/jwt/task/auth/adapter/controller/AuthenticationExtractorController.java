package com.jwt.task.auth.adapter.controller;

import com.jwt.task.auth.entity.ExtractorResponse;
import com.jwt.task.auth.service.AuthenticationExtractorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationExtractorController {
    private final AuthenticationExtractorService authenticationExtractorService;

    @GetMapping("/info")
    public ResponseEntity<ExtractorResponse> authenticate(@NonNull HttpServletRequest request
    ){
        log.info("[UBA] /authenticate is called");
        return ResponseEntity.ok(authenticationExtractorService.extractToken(request));
    }
}
