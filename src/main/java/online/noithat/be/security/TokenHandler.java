package online.noithat.be.security;

import io.jsonwebtoken.*;
import online.noithat.be.Entity.Account;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class TokenHandler {
    private final String SECRET_KEY = "NOI_THAT";
    //    1s => 1000ms
//    private final UUID EXPIRATION = 1 * 60 * 1000;
    private final long EXPIRATION = 1 * 24 * 60 * 60 * 1000;

    // create token (encode)
    public String generateToken(Account userSecurity) {
        Date now = new Date(); // get current time
        Date expirationDate = new Date(now.getTime() + EXPIRATION);

        String token = Jwts.builder()
                .setSubject(userSecurity.getUsername()+"")
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        return token;
    }


    // validate token
    // get info from token (decode)
    public String getInfoByToken(String token) throws ExpiredJwtException, MalformedJwtException {
        String username;
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        username = claims.getSubject();
        // xuống đc đây => token đúng
        return username;
    }

    public Date getExpiredDate(String token) {
        Date date = null;
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            date = claims.getExpiration();
            // xuống đc đây => token đúng
        } catch (ExpiredJwtException expiredJwtException) {
            System.out.println(expiredJwtException.getMessage());
        }
        return date;
    }
}
