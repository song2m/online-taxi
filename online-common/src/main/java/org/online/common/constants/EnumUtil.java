package org.online.common.constants;

public class EnumUtil {

    public static final String UNKNOWN = "其他";

    public static String getEnumByCode(Class<? extends BaseEnum> tClass, Integer key) {

        BaseEnum[] enums = tClass.getEnumConstants();
        for (BaseEnum anEnum : enums) {
            if (anEnum.getKey().equals(key)) {
                return anEnum.getValue();
            }
        }
        return UNKNOWN;
    }
}
