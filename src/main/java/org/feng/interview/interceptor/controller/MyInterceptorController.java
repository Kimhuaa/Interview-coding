package org.feng.interview.interceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 请求控制器
 * @Author Zhu XueFeng
 * @Date 2024/7/25 13:06
 */
@RestController
@RequestMapping("/myinterceptor")
public class MyInterceptorController {
    @RequestMapping("/hello")
    public String hello() {
        return "时空诗是个圆圈, 直行或是转弯，我们最终都会相见";
    }
}
