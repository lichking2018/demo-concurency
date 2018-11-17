package com.imook.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/4 1:07 PM
 * @Version: v1.0
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
