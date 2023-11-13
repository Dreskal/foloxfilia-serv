package com.foloxfilia.foloxfiliaserv.security;

import com.foloxfilia.foloxfiliaserv.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public final JwtService jwtService;
    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain)
            throws ServletException, IOException {

       final String authHeader = request.getHeader("Authorization");
    //если есть токен то
       if(authHeader != null && authHeader.startsWith("Bearer ")){
            //берем токен из отдельного класса
           String jwt = authHeader.substring(7);
           String username = jwtService.extractUsername(jwt);


       }
       // ошибка 403
        filterChain.doFilter(request, response);
    }
}
