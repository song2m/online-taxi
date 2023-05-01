package org.online.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderEnum implements BaseEnum {

    MALE(1, "男"),
    FEMALE(0, "女");

    private final Integer key;
    private final String value;
}
