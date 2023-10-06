package RiEZAS.business.impl.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import RiEZAS.business.api.dto.security.RoleDto;
import RiEZAS.business.api.dto.security.UserDto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class JwtTokenUtils {

    private static String secret = "very1long1and1reliable1secret1for1very1reliable1json1web1token";
    private static int lifetime = 10800000;

    public static String generateToken(UserDto user) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = user.getRoles().stream()
                .map(RoleDto::getName)
                .collect(Collectors.toList());
        claims.put("roles", roles);
        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + lifetime);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getName())
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static String getName(String token) {
        return getClaims(token).getSubject();
    }

    public static List<String> getRoles(String token) {
        return getClaims(token).get("roles", List.class);
    }

    private static Claims getClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
