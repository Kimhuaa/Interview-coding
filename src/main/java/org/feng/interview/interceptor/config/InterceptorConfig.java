package org.feng.interview.interceptor.config;

import org.feng.codingmore.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 自定义拦截器配置
 * @Author Zhu XueFeng
 * @Date 2024/7/25 12:57
 */
// 这段代码用于配置 WebMvc 中间件，在本例中使用了 LoggerInterceptor 类。下面是加上注释后的代码：
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加 LoggerInterceptor 类为 WebMvc 中间件
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
