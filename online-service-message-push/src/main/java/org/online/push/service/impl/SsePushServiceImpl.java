package org.online.push.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.online.common.configs.BusinessException;
import org.online.common.dto.PushMessageParam;
import org.online.common.utils.SsePrefixUtils;
import org.online.push.service.ISsePushService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class SsePushServiceImpl implements ISsePushService {

    private static final Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    @Override
    public SseEmitter connect(String phone, String identity) {

        SseEmitter sseEmitter = new SseEmitter(0L);
        String sseKey = SsePrefixUtils.generatorSseKey(phone, identity);
        sseEmitterMap.put(sseKey, sseEmitter);
        return sseEmitter;
    }

    @Override
    public void pushMessage(PushMessageParam param) {

        String phone = param.getPhone();
        String identity = param.getIdentity();
        String content = param.getContent();
        String sseKey = SsePrefixUtils.generatorSseKey(phone, identity);

        if (sseEmitterMap.containsKey(sseKey)) {
            SseEmitter sseEmitter = sseEmitterMap.get(sseKey);
            try {
                sseEmitter.send(content);
            } catch (Exception e) {
                log.error("消息推送失败：{}", sseKey);
                throw new BusinessException("消息推送失败");
            }
        }
    }

    @Override
    public void closeConnect(String phone, String identity) {
        String sseKey = SsePrefixUtils.generatorSseKey(phone, identity);
        sseEmitterMap.remove(sseKey);
    }
}
