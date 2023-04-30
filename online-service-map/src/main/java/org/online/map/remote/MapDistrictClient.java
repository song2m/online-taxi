package org.online.map.remote;

import org.apache.http.client.utils.URIBuilder;
import org.online.common.constants.AmapConfigConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class MapDistrictClient {

    @Value("${amap.key}")
    private String amapKey;

    @Resource
    private RestTemplate restTemplate;


    /**
     * 行政区域查询
     *
     * @param keywords 查询关键字
     */
    public String searchDistrict(String keywords) {
        try {
            URIBuilder uri = new URIBuilder(AmapConfigConstants.DISTRICT_URL);
            uri.addParameter("key", amapKey);
            uri.addParameter("keywords", keywords);
            uri.addParameter("subdistrict", "3");
            uri.addParameter("extensions", "base");
            ResponseEntity<String> result = restTemplate.getForEntity(uri.build(), String.class);
            return result.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
