package com.april.house.cloud.house.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Creation :  2018-12-19 17:56
 * --------  ---------  --------------------------
 */

@ConfigurationProperties(prefix = HttpClientProperties.HTTPCLIENT_PREFIX)
public class HttpClientProperties {
    public static final String HTTPCLIENT_PREFIX = "spring.httpclient";

    private Integer connectTimeOut = 1000;
    private Integer socketTimeOut = 10000;
    private String agent = "agent";
    private Integer maxConnPerRoute = 10;
    private Integer maxConnTotal = 50;

    public Integer getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(Integer connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public Integer getSocketTimeOut() {
        return socketTimeOut;
    }

    public void setSocketTimeOut(Integer socketTimeOut) {
        this.socketTimeOut = socketTimeOut;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Integer getMaxConnPerRoute() {
        return maxConnPerRoute;
    }

    public void setMaxConnPerRoute(Integer maxConnPerRoute) {
        this.maxConnPerRoute = maxConnPerRoute;
    }

    public Integer getMaxConnTotal() {
        return maxConnTotal;
    }

    public void setMaxConnTotal(Integer maxConnTotal) {
        this.maxConnTotal = maxConnTotal;
    }
}
