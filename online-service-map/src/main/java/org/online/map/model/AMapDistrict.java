package org.online.map.model;

import lombok.Data;

import java.util.List;

@Data
public class AMapDistrict {

    private String citycode;
    private String adcode;
    private String name;
    private String polyline;
    private String center;
    private String level;
    private List<AMapDistrict> districts;
}
