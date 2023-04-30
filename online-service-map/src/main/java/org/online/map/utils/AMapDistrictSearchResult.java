package org.online.map.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.online.map.model.AMapDistrict;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AMapDistrictSearchResult extends AMapBaseResult {

    @Data
    private class Suggestion {
        List<String> keywords;
        List<String> cities;

    }

    private Integer count;
    private List<AMapDistrict> districts;
    private List<Suggestion> suggestions;
}
