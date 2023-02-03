package com.jwt.task.adapter.controller;

import com.jwt.task.entity.AuthenticationRequest;
import com.jwt.task.entity.AuthenticationResponse;
import com.jwt.task.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        log.info("[UBA] /authenticate is called");
        log.info("[UBA] /user" + request);
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
