package com.lsm.app.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apollo")
public class ApolloController {

    /**
     * 配置文件句柄
     */
    @ApolloConfig
    private Config config;

    @GetMapping("/test")
    public String test() {
        //第一个参数是配置文件的属性值
        return config.getProperty("server.port", "");
    }

    //没什么用,纯粹就是为了做一次零代码的提交,用于贡献github积分
}
