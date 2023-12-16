package com.foloxfilia.foloxfiliaserv.Service;

import com.foloxfilia.foloxfiliaserv.DTO.request.AuthRequest;
import com.foloxfilia.foloxfiliaserv.DTO.request.RegisterRequest;
import com.foloxfilia.foloxfiliaserv.DTO.responce.AuthResponce;
import com.foloxfilia.foloxfiliaserv.entity.Contacts;
import com.foloxfilia.foloxfiliaserv.entity.Users;
import com.foloxfilia.foloxfiliaserv.entity.enums.ERole;
import com.foloxfilia.foloxfiliaserv.repository.ContactsRepository;
import com.foloxfilia.foloxfiliaserv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ContactsRepository contactsRepository;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthResponce register(RegisterRequest request){
        Users user = Users.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .createDate(LocalDateTime.now())
                .contacts(
                        contactsRepository.save(
                                new Contacts(
                                        request.getName(),
                                        request.getEmail(),
                                        false
                                )
                        )

                )
                .role(Collections.singleton(ERole.USER))
                .build();
        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String jwt = jwtService.generateToken(userDetails);
        return AuthResponce.builder().token(jwt).build();
    }
    public AuthResponce authenticate (AuthRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String jwt = jwtService.generateToken(userDetails);
        return AuthResponce.builder().token(jwt).build();
    }
}
