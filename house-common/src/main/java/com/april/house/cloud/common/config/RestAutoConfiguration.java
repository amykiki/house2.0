package com.april.house.cloud.common.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.http.client.HttpClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;

@Configuration
public class RestAutoConfiguration {

    @Bean("lbRestTemplate")
    @LoadBalanced
    public RestTemplate lbRestTemplate(HttpClient httpClient) {
        return genTemplate(httpClient);
    }

    @Bean("directTemplate")
    //设置directTemplate，是为了测试方便，直接指定ip+端口号
    public RestTemplate directTemplate(HttpClient httpClient) {
        return genTemplate(httpClient);
    }

    @Bean
    public GenericRest genericRest() {
        return new GenericRest();
    }
    private RestTemplate genTemplate(HttpClient httpClient) {
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
        //resttemplate需要发送请求和接收响应。发送和接收时都需要把对象序列化成一定的字符串或字节数组
        //如果发送的的字符串是包含中文字符，需要编码。默认字符集为ISO-8859，因此需要指定为UTF-8
        template.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("utf-8")));
        //希望接受的响应能通过json进行反序列化， 默认使用jackson，为了更快，可以使用fastjson
        template.getMessageConverters().add(1, new FastJsonConverterForJson());
        return template;
    }

    private static class FastJsonConverterForJson extends FastJsonHttpMessageConverter {
        static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

        public FastJsonConverterForJson() {
            setDefaultCharset(DEFAULT_CHARSET);
            setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, new MediaType("application", "*+json")));
        }
    }


}
