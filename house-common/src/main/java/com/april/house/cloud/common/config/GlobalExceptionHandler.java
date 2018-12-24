package com.april.house.cloud.common.config;

import com.april.house.cloud.common.enums.RestCode;
import com.april.house.cloud.common.model.RestResponse;
import com.april.house.cloud.common.utils.Exception2CodeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @Creation :  2018-12-24 17:39
 * --------  ---------  --------------------------
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public RestResponse<Object> handler(HttpServletRequest req, Throwable throwable) {
        LOGGER.error(throwable.getMessage(), throwable);
        RestCode restCode = Exception2CodeRepo.getCode(throwable);
        RestResponse<Object> response = new RestResponse<>(restCode.getCode(), restCode.getMsg());
        return response;
    }
}
