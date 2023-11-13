package com.foloxfilia.foloxfiliaserv.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {

    private static final String SALT = "b31b4a75f21e8266cc82bb9713041467a8e2b0217b73ec1ebc01c33b3a561567";

    public String extractUsername(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }

    public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);

    }

    public String generateToken (Map<String, Object> exstraClaim, UserDetails details){
        return null;
    }
    private Claims extractAllClaims(String jwt){

        return Jwts
                .parserBuilder()
                .setSigningKey(getSingingKey())
                .build()
                .parseClaimsJwt(jwt)
                .getBody();
    }
    private Key getSingingKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SALT);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
