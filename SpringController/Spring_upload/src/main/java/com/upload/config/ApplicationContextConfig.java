//package com.upload.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//@Configuration
//public class ApplicationContextConfig {
//    @Bean(name = "multipartResolver")
//    public MultipartResolver getMultipartResolver() {
//        CommonsMultipartResolver resover = new CommonsMultipartResolver();
//        // 1MB
//        resover.setMaxUploadSize(1024 * 1024 * 1024);
//
//        return resover;
//    }
//}
