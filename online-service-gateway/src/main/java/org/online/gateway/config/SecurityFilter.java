package org.online.gateway.config;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.online.common.constants.CommonStatusEnum;
import org.online.common.constants.TokenConstants;
import org.online.common.utils.JwtUtil;
import org.online.common.utils.RedisPrefixUtils;
import org.online.common.utils.ResponseResult;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

/**
 * 网关层对jwt进行校验
 *
 * @author songming
 */
@Component
@Slf4j
public class SecurityFilter implements GlobalFilter, Ordered {

    @Resource
    private NacosConfProperties nacosConfProperties;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private final Gson gson = new Gson();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 判断是否需要认证
        Boolean authentication = nacosConfProperties.getWhetherEnableAuthentication();
        if (!authentication)
            return chain.filter(exchange);

        String url = exchange.getRequest().getURI().getPath();
        // 获取请求URL路径，白名单放行
        List<String> whiteURLs = nacosConfProperties.getWhiteURL();
        for (String whiteURL : whiteURLs) {
            if (antPathMatcher.match(whiteURL, url))
                return chain.filter(exchange);
        }

        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (!StringUtils.hasText(token))
            return noPower(exchange, CommonStatusEnum.TOKEN_NULL);

        try {
            Claims claims = JwtUtil.parseToken(token);
            String phone = claims.get(JwtUtil.JWT_KEY_PHONE, String.class);
            Integer identity = claims.get(JwtUtil.JWT_KEY_IDENTITY, Integer.class);

            String tokenKey = RedisPrefixUtils.generatorTokenKey(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
            String tokenValue = stringRedisTemplate.opsForValue().get(tokenKey);

            if (!StringUtils.hasText(tokenValue) || !tokenValue.trim().equals(token.trim()))
                return noPower(exchange, CommonStatusEnum.TOKEN_ERROR);
        } catch (Exception e) {
            return noPower(exchange, CommonStatusEnum.TOKEN_ERROR);
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }


    /**
     * 没有访问权限
     */
    private Mono<Void> noPower(ServerWebExchange exchange, CommonStatusEnum statusEnum) {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");

        String error = gson.toJson(ResponseResult.error(statusEnum));
        DataBuffer buffer = response.bufferFactory().wrap(error.getBytes());
        return response.writeWith(Mono.just(buffer));
    }
}
