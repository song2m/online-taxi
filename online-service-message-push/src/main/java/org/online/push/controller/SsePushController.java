package org.online.push.controller;

import org.online.common.dto.PushMessageParam;
import org.online.push.service.ISsePushService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;

@RestController
public class SsePushController {

    @Resource
    private ISsePushService ssePushService;

    @GetMapping("sse/connect")
    public SseEmitter connect(@RequestParam String phone,
                              @RequestParam String identity) {
        return ssePushService.connect(phone, identity);
    }

    @GetMapping("sse/close")
    public void close(@RequestParam String phone,
                      @RequestParam String identity) {
        ssePushService.closeConnect(phone, identity);
    }

    @PostMapping("sse/push")
    public void push(@RequestBody PushMessageParam param) {
        ssePushService.pushMessage(param);
    }
}
