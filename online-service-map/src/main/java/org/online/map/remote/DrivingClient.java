package org.online.map.remote;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.online.common.constants.AmapConfigConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Slf4j
public class DrivingClient {

    @Value("${amap.key}")
    private String amapKey;

    @Resource
    private RestTemplate restTemplate;


    /**
     * 计算两点距离
     *
     * @param start    起点经纬度 a,b
     * @param end      目的地经纬度
     * @param strategy 路线策略
     */
    public String countDistance(String start, String end, String strategy) {

        try {
            URIBuilder uri = new URIBuilder(AmapConfigConstants.DIRECTION_URL);
            uri.addParameter("key", amapKey);
            uri.addParameter("origin", start);
            uri.addParameter("destination", end);
            uri.addParameter("strategy", strategy);
            ResponseEntity<String> response = restTemplate.getForEntity(uri.build(), String.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
