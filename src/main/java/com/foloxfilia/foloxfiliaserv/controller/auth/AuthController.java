package com.foloxfilia.foloxfiliaserv.controller.auth;

import com.foloxfilia.foloxfiliaserv.DTO.request.AuthRequest;
import com.foloxfilia.foloxfiliaserv.DTO.request.RegisterRequest;
import com.foloxfilia.foloxfiliaserv.DTO.responce.AuthResponce;
import com.foloxfilia.foloxfiliaserv.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponce> register (@RequestBody RegisterRequest request){

        return ResponseEntity.ok(authService.register(request));

    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponce> authenticate (@RequestBody AuthRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
