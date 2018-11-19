package com.imook.study.controller;

import com.imook.study.threadLocal.RequesthHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 10:07 PM
 * @Version: v1.0
 */
@RestController
@RequestMapping("threadLocal")
public class ThreadLocalController {

    @GetMapping("/test")
    public Long test(){
        return RequesthHolder.getId();
    }
}
