package com.springcloud.controller;

import com.springcloud.service.IMessageProvider;
import com.springcloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2020-12-30 13:56
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
