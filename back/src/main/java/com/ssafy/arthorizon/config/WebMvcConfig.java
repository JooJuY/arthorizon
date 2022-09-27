package com.ssafy.arthorizon.config;

import com.ssafy.arthorizon.common.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableJpaRepositories(basePackages = {"com.ssafy.arthorizon.user.Repository"})
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.jwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/users/signup")
                .excludePathPatterns("/api/users/check")
                .excludePathPatterns("/api/users/login")
                .excludePathPatterns("/api/users/profile/**")
                .excludePathPatterns("/api/users/followers/**")
                .excludePathPatterns("/api/users/followings/**")
                .excludePathPatterns("/api/search/**")
                .excludePathPatterns("/api/pieces/**")
                .excludePathPatterns("/api/game/**")
                .excludePathPatterns("/api/service/notice")
                .excludePathPatterns("/api/service/notice/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .maxAge(6000);
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOriginPattern("*");
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        configuration.addExposedHeader("*");
//        configuration.setAllowCredentials(true);
//        configuration.setMaxAge(3600L);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
    @Bean
    protected JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }
}