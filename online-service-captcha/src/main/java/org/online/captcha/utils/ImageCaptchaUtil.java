package org.online.captcha.utils;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;

import java.awt.*;

/**
 * 生成图形验证码
 *
 * @author songming
 */
public class ImageCaptchaUtil {

    public static SpecCaptcha buildImageCaptcha() {
        // 设置宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(129, 48, 4);
        // 设置字体
        Font font = new Font("Times New Roman", Font.ITALIC, 34);
        specCaptcha.setFont(font);
        // 设置类型
        specCaptcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);
        return specCaptcha;
    }
}
