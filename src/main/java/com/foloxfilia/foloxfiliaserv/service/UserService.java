package com.foloxfilia.foloxfiliaserv.service;

import com.foloxfilia.foloxfiliaserv.entity.Users;
import com.foloxfilia.foloxfiliaserv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Users getByPrincipal(Principal principal){
       String username = principal.getName();

       return userRepository.findByUsername(username).orElseThrow(
               () -> new  UsernameNotFoundException(username + " not found")
       );
    }
}
