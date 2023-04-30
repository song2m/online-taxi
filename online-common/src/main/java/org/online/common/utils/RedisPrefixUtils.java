package org.online.common.utils;

/**
 * redis缓存key前缀
 *
 * @author songming
 */
public class RedisPrefixUtils {

    /**
     * 乘客验证码的前缀
     */
    public static String captchaPrefix = "captcha-";

    /**
     * token存储的前缀
     */
    public static String tokenPrefix = "token-";

    /**
     * 黑名单设备号
     */
    public static String blackDeviceCodePrefix = "black-device-";

    /**
     * 根据手机号，生成key
     */
    public static String generatorKeyByPhone(String phone, int identity) {
        return captchaPrefix + identity + "-" + phone;
    }

    /**
     * 根据手机号和身份标识，生成token
     */
    public static String generatorTokenKey(String phone, int identity, String tokenType) {
        return tokenPrefix + phone + "-" + identity + "-" + tokenType;
    }
}
