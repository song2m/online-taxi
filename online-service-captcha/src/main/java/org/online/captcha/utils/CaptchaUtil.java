package org.online.captcha.utils;

import java.util.Random;

/**
 * 验证码工具
 *
 * @author songming
 */
public class CaptchaUtil {

    /**
     * 字母+数字验证码生成
     *
     * @param length 验证码长度
     * @return 验证码串
     */
    public static String builderCaptchaWithWords(int length) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return (sb.toString());
    }

    /**
     * 字母+数字验证码生成
     *
     * @param length 验证码长度
     * @return 验证码串
     */
    public static String builderCaptchaOnlyNumber(int length) {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return (sb.toString());
    }

    /**
     * 不区分大小写匹配验证码
     */
    public static boolean matchingCaptcha(String sourceCode, String targetCode) {
        String sourceCodeToUpperCase = sourceCode.toUpperCase();
        String targetCodeToUpperCase = targetCode.toUpperCase();
        return sourceCodeToUpperCase.equals(targetCodeToUpperCase);
    }


}
