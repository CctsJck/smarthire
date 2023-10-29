package com.smarthire.project.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.*;
@Slf4j
public class TokenUtils {
    @Value("${JAVA_PRUEBA_STRING}")
    private static String ACCESS_TOKEN_SECRET;
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    @Value("${JAVA_PRUEBA_STRING}")
    private String accessTokenSecretFromProperty;

    @PostConstruct
    public void initializeAccessTokenSecret() {
        log.info(accessTokenSecretFromProperty);
        ACCESS_TOKEN_SECRET = accessTokenSecretFromProperty;
    }

    public static String createToken(String name, String email){
         long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
         Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

         Map<String, Object> extra = new HashMap<>();
         extra.put("name", name);
         return Jwts.builder()
                 .setSubject(email)
                 .setExpiration(expirationDate)
                 .addClaims(extra)
                 .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                 .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
            Claims claims =Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email ,null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }

    }
}
