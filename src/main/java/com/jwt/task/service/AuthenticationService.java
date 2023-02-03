package com.jwt.task.service;

import com.jwt.task.adapter.persistence.UserRepository;
import com.jwt.task.config.JwtService;
import com.jwt.task.entity.AuthenticationRequest;
import com.jwt.task.entity.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthenticationResponse authenticate(AuthenticationRequest request){
        try {
            log.info("[UBA] /auth req" + request);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getPhone(),
                            request.getPassword()
                    )
            );
            log.info("[UBA] /authenticationManager is called");
            var user = userRepository.findByPhone(request.getPhone())
                    .orElseThrow();
            log.info("[UBA] /user is" + user);
            var jwtToken = jwtService.generateToken(user);
            log.info("[UBA] /jwtToken is" + jwtToken);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }catch (Exception e){
            log.info("[UBA] /error is " + e);
            return AuthenticationResponse.builder().build();
        }
    }

}
