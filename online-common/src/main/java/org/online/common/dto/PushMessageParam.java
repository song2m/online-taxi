package org.online.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PushMessageParam {

    private String phone;
    private String identity;
    private String content;
}
