package com.server.bebidasGM.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;



import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class TokenUtils{

  private final static String ACCESS_TOKEN_SECRET = "QXvBpk1I_bGpOE_dAqDrNaiLL59uHOFXHIALraDo0sA"; //MORELIA2023, la del admin: $2a$10$iEUPbmD6jiLx/uGHfWK9Q.08Gt0.TnBS1QfHtwPusLV0vtp34fNYm

  private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

  public static String createToken(String nombre,String celular){
    /*long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS *1_000;
    Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);*/


    Map<String, Object> extra = new HashMap<>();
    extra.put("nombre", nombre);

    byte[] secret = ACCESS_TOKEN_SECRET.getBytes();
    Key key = Keys.hmacShaKeyFor(secret);

    return Jwts.builder()
      .setSubject(celular)
      //.setExpiration(expirationDate)
      .addClaims(extra)
      .signWith(key, SignatureAlgorithm.HS256)
      .compact();
  }

  public static UsernamePasswordAuthenticationToken getAuthentication(String token){
    try {
      Claims claims = Jwts.parserBuilder()
        .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
        .build()
        .parseClaimsJws(token)
        .getBody();

      String celular = claims.getSubject();

      return new UsernamePasswordAuthenticationToken(celular, null, Collections.emptyList());
    } catch (JwtException e){
      return null;
    }
  }

}
