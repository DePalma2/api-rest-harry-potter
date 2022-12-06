package com.apiharrypotter.config.jwt;

import com.apiharrypotter.config.CustomUserDetails;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${apiHarryPotter.jwt.secret}")
    private String secret;

    @Value("${apiHarryPotter.jwt.expiration}")
    private int expiration;


    public String generateToken(Authentication authentication){
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return Jwts.builder().setSubject(customUserDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000L))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Malformed token");
        }catch (UnsupportedJwtException e){
            logger.error("Token not supported");
        }catch (ExpiredJwtException e){
            logger.error("Token expired");
        }catch (IllegalArgumentException e){
            logger.error("Void Token");
        }catch (SignatureException e){
            logger.error("Failed Signature");
        }
        return false;
    }
}
