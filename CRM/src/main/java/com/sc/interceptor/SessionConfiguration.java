package com.sc.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SessionConfiguration implements WebMvcConfigurer {

	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addPathPatterns = registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
        addPathPatterns.excludePathPatterns("/loginctlr/login.do");
    }
}
