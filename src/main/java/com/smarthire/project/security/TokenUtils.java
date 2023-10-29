package com.smarthire.project.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Key;
import java.util.*;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "qf4243omf234mfdmfmi2i34fmdm3imdmwif4";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 3600L;

    public static String createToken(Long id, String email){
         long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
         Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

         Map<String, Object> extra = new HashMap<>();
         extra.put("id", id);
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
