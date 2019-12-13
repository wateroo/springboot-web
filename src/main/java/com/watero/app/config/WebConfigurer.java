package com.watero.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

//    private final LoginInterceptor loginInterceptor;
//
//    @Autowired
//    public WebConfigurer(LoginInterceptor loginInterceptor) {
//        this.loginInterceptor = loginInterceptor;
//    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问 "/" 和 "/index.html" 默认映射到login 登录页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        //测试页面
        registry.addViewController("/tip").setViewName("index");
        //测试 success
        registry.addViewController("/success").setViewName("success");
        //主页
        registry.addViewController("/main.html").setViewName("main");
    }

    //这个方法是用来配置静态资源的,比如html,js,css,等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
//        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
    }

    //这个方法用来注册拦截器,我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(loginInterceptor) 添加自定义的拦截器
        // registry.addPathPatterns("/**")表示拦截所有的请求
        //excludePathPatterns("/login","/register")表示除了登陆与注册之外,因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
        .excludePathPatterns(Arrays.asList("/static/**", "/resources/**","/public/**","/webjars/**","/favicon.ico"))
        .excludePathPatterns(Arrays.asList("/", "/index.html", "/user/login", "/user/logout"));
    }
}