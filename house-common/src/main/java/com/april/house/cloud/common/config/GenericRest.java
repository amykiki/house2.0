package com.april.house.cloud.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 有两种restTemplate,一种是负载均衡的，一种是直连的。
 * 统一在该类中处理
 */
@Service
public class GenericRest {
    @Autowired
    private RestTemplate lbRestTemplate;

    @Autowired
    private RestTemplate directTemplate;

    public static final String DIR_FLAG = "direct://";

    public <T> ResponseEntity<T> post(String url, Object reqBody, ParameterizedTypeReference<T> respType) {
        RestTemplate template = getRestTemplate(url);
        url = url.replace(DIR_FLAG, "");
        return template.exchange(url, HttpMethod.POST, new HttpEntity<>(reqBody), respType);
    }

    public <T> ResponseEntity<T> get(String url, ParameterizedTypeReference<T> respType) {
        RestTemplate template = getRestTemplate(url);
        url = url.replace(DIR_FLAG, "");
        return template.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, respType);
    }

    private RestTemplate getRestTemplate(String url) {
        if (url.startsWith(DIR_FLAG)) {
            return directTemplate;
        }
        return lbRestTemplate;
    }

}
