package lk.acpt.riyapola.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lk.acpt.riyapola.dto.AdminDto;
import lk.acpt.riyapola.entity.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;

@Component
public class JWTTokenGenerator {
    @Value("${acpt.app.jwtSecret}")
    private String jwtSecret;
    @Value("${acpt.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(AdminDto adminDto) {
        return Jwts.builder()
                .setId(String.valueOf(adminDto.getId()))
                .setSubject((adminDto.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        String jwtToken = authToken.substring("Bearer ".length());
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(jwtToken);
            return true;
        } catch (Exception e) {
            System.out.println("Error when generating token...");
        }

        return false;
    }
}
