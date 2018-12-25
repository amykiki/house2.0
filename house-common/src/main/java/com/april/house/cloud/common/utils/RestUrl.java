package com.april.house.cloud.common.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@Slf4j
public class RestUrl {

    public static String genGetRestUrl(String serviceName, String controllerName, String methodName, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder("http://");
        sb.append(serviceName);
        sb.append("/");
        sb.append(controllerName);
        sb.append("/");
        sb.append(methodName);
        if (null != params) {
            sb.append("?");
            Map<String, String> newMap = Maps.newHashMap();
            params.forEach((k, v) -> {
                if (v != null) {
                    try {
                        newMap.put(k, URLEncoder.encode(v.toString(), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        log.error("URLEncoder.encode fail: " + k +  ": " + v.toString());
                    }
                }
            });
            sb.append(Joiner.on("&").useForNull("").withKeyValueSeparator("=").join(newMap));
        }
        return sb.toString();

    }
}
