//package com.zhss.boot.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.format.datetime.DateFormatter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MvcConfigurer  implements WebMvcConfigurer {
//
//    //添加拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/user/**");
//    }
//
//    //跨域配置
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/user/**").allowedOrigins("").allowedMethods("POST","GET");
//    }
//
//    //格式化
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
//    }
//
//
//}
