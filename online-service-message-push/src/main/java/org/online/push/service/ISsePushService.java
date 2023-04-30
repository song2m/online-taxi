package org.online.push.service;

import org.online.common.dto.PushMessageParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface ISsePushService {

    /**
     * 建立连接
     *
     * @param phone    手机号码
     * @param identity 身份
     */
    SseEmitter connect(String phone, String identity);

    /**
     * 推动消息
     *
     * @param param id+身份+消息内容
     */
    void pushMessage(PushMessageParam param);


    /**
     * 关闭连接
     *
     * @param phone    手机号码
     * @param identity 身份
     */
    void closeConnect(String phone, String identity);
}
