package com.lzj.smsboom.config;

import com.lzj.smsboom.app.Boom;
import com.lzj.smsboom.interceptor.HttpRequestAndResponseInterceptor;
import com.lzj.smsboom.utils.SmsBoomURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/11/14 21:04
 */
@Configuration
public class RestTemplateConfig {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class);

    @Bean
    public RestTemplate restTemplate() {
        // 添加内容转换器,使用默认的内容转换器
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        // 设置编码格式为UTF-8
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> converter : converterList) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter)converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
            if (converter instanceof MappingJackson2HttpMessageConverter){
                MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = ((MappingJackson2HttpMessageConverter) converter);
                jackson2HttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
            }
        }

        //添加过滤器
        restTemplate.setInterceptors(Arrays.asList(httpRequestAndResponseInterceptor()));

        return restTemplate;
    }
    @Bean
    public SmsBoomURL smsBoomURL(){
        return new SmsBoomURL();
    }

    @Bean
    public Boom boom(){
        return new Boom();
    }
    @Bean
    public HttpRequestAndResponseInterceptor httpRequestAndResponseInterceptor(){
        return new HttpRequestAndResponseInterceptor();
    }
}