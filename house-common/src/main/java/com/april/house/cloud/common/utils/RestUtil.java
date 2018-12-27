package com.april.house.cloud.common.utils;

import com.april.house.cloud.common.exception.RestException;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.reflect.FieldUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.Callable;

@Slf4j
public class RestUtil {
    private RestUtil() {}

    private static DefaultHandler defaultHandler = new DefaultHandler();

    public static <T> T exc(Callable<T> callable) {
        return exc(callable, defaultHandler);
    }


    public static <T> T exc(Callable<T> callable, ResultHandler resultHandler) {
        T result = sendReq(callable);
        return resultHandler.handle(result);
    }

    public static class DefaultHandler implements ResultHandler {

        @Override
        public <T> T handle(T result) {
            int code = 1;
            String msg = "";
            try {
                code = (Integer) FieldUtils.readDeclaredField(result, "code", true);
                msg = (String) FieldUtils.readDeclaredField(result, "msg", true);
            } catch (IllegalAccessException e) {
                log.error("Read Filed Failed");
            }

            if (code != 0) {
                throw new RestException("Get ErrorCode " + code + " when execute rest call with errorMsg " + msg);
            }
            return result;
        }
    }

    public interface ResultHandler {
        <T> T handle(T result);
    }

    private static <T> T sendReq(Callable<T> callable) {
        T result = null;
        try {
            result = callable.call();
        } catch (Exception e) {
            throw new RestException("sendReq Error by " + e.getMessage());
        } finally {
            log.info("result = {}", result);
        }
        return result;
    }

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
