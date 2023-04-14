package miu.edu.lab5.springsecurity.service;

import miu.edu.lab5.springsecurity.entity.dto.request.LoginRequest;
import miu.edu.lab5.springsecurity.entity.dto.response.LoginResponse;
import miu.edu.lab5.springsecurity.entity.dto.request.RefreshTokenRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
