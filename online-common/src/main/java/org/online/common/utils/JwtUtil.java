package org.online.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具
 *
 * @author songming
 */
public class JwtUtil {

    /**
     * 盐
     */
    private final static String SECRET = "didi-online-taxi";

    /**
     * 乘客身份，1:乘客，2:司机
     */
    public static final String JWT_KEY_IDENTITY = "identity";

    /**
     * 令牌类型，accessToken，refreshToken
     */
    public static final String JWT_TOKEN_TYPE = "tokenType";

    /**
     * 手机号码
     */
    public static final String JWT_KEY_PHONE = "phone";

    /**
     * 生成token
     *
     * @param phone     手机号
     * @param identity  身份
     * @param tokenType 令牌类型
     * @return token
     */
    public static String generatorToken(String phone, Integer identity, String tokenType) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JWT_KEY_PHONE, phone);
        claims.put(JWT_KEY_IDENTITY, identity);
        claims.put(JWT_TOKEN_TYPE, tokenType);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .compact();
    }

    /**
     * 解析令牌信息
     *
     * @param token token令牌
     * @return claims载体
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
