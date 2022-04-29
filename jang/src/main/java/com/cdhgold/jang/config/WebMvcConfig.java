package com.cdhgold.jang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
 
  
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/",".jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) { 
        //registry.addInterceptor(iconPlusInterceptor()).addPathPatterns("/*");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      
        registry.addResourceHandler("/static/files/**","/webjars/bootstrap/**")
        .addResourceLocations("classpath:/static/files/","/static/files/" ,"classpath:/webjars/bootstrap/","/webjars/bootstrap/" );

       // WebMvcConfigurer.super.addResourceHandlers(registry);
    }
  
//    @Bean
//    public IconPlusInterceptor iconPlusInterceptor() {
//        return new IconPlusInterceptor();
//    }
 
 
 
 
}
