package org.online.common.utils;

public class SsePrefixUtils {

    private static  final String operator = "$";

    public  static String generatorSseKey(String phone , String identity){
        return phone+ operator +identity;
    }
}
