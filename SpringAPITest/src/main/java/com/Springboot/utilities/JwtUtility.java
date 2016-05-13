package com.Springboot.utilities;

import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JwtUtility {
	
	public static Claims decodeToken(String jwt, String privateKey){
        System.out.println(privateKey);
		Jws<Claims> claimString = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(privateKey))
                .parseClaimsJws(jwt);
		
		System.out.println(claimString);
		
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(privateKey))
                .parseClaimsJws(jwt).getBody();
        System.out.println(claims.getClass());

        return claims;
    }

    public static String getUserId(String jwt, String privateKey){
    	Claims claims = decodeToken(jwt, privateKey);
        String userId = (String)claims.get("id");
        return userId;
    }

}
