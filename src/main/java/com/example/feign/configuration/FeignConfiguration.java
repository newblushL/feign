package com.example.feign.configuration;

import com.example.feign.interceptor.FeignBasicAuthRequestInterceptor;
import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Feign配置
 * @author: ll
 * @create: 2019-08-06 20:50
 */
@Configuration
public class FeignConfiguration {

    /**
     * @Author: LL
     * @Description: FULL输出完整日志
     * @Date: 2019-08-06
     * @return: feign.Logger.Level
     **/
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * @Author: LL
     * @Description: Feign契约配置
     * @Date: 2019-08-06
     * @return: feign.Contract
     **/
    /*@Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }*/

    /**
     * @Author: LL
     * @Description: Feign Basic认证配置
     * @Date: 2019-08-06
     * @return: feign.auth.BasicAuthRequestInterceptor
     **/
    /*@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }*/

    /**
     * @Author: LL
     * @Description: 自定义拦截器配置
     * @Date: 2019-08-06
     * @return: com.example.feign.interceptor.FeignBasicAuthRequestInterceptor
     **/
    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    /**
     * @Author: LL
     * @Description: 超时时间配置
     * @Date: 2019-08-06
     * @return: feign.Request.Options
     **/
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

    /**
     * @Author: LL
     * @Description: Feign自定义解码器
     * @Date: 2019-08-06
     * @return: feign.codec.Decoder
     **/
    @Bean
    public Decoder decoder(){
        return new MyDecoder();
    }

    /**
     * @Author: LL
     * @Description: Feign自定义编码器
     * @Date: 2019-08-06
     * @return: feign.codec.Encoder
     **/
    @Bean
    public Encoder encoder(){
        return new MyEncoder();
    }
}