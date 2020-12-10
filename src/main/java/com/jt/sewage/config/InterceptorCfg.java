package com.jt.sewage.config;



import com.jt.sewage.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorCfg implements WebMvcConfigurer {
    @Bean
    public MyInterceptor myInterceptor(){
        return  new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        //InterceptorRegistration registration = registry.addInterceptor(new MyInterceptor());
        InterceptorRegistration registration = registry.addInterceptor(myInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
//                "你的登陆路径",            //登录
//                "/**/*.html",            //html静态资源
                "/js/*.js",              //js静态资源
                "/css/*.css",             //css静态资源
//                "/**/*.png",
                "/img/*.jpg"
//                "/**/*.gif",
//                "/**/*.woff",
//                "/**/*.ttf"
        );
    }



}
