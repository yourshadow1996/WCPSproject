package com.tnpy.common.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //System.out.println("拦截器设置！CorsConfig");
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE")
                .allowCredentials(true).maxAge(3600);
    }

    @Bean
    TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // System.out.println("=============================初始化拦截器");
        //添加拦截器
        //registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/login","/user/hello");//放掉某些特定不需要校验token的路由
        // registry.addInterceptor(tokenInterceptor()).addPathPatterns("/tokentest/**");
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**");
        //super.addInterceptors(registry);
    }
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/api/**").addResourceLocations("classpath:/static/");
//
//	}
}





