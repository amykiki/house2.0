package com.april.house.cloud.common.model;

import com.april.house.cloud.common.enums.RestCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Creation :  2018-12-24 17:36
 * --------  ---------  --------------------------
 */
@Getter
@Setter
public class RestResponse<T> {
    private int code;
    private String msg;
    private T result;

    public static <T> RestResponse<T> success() {
        return new RestResponse<>();
    }

    public static <T> RestResponse<T> success(T result) {
        RestResponse<T> response = new RestResponse<>();
        response.setResult(result);
        return response;
    }

    public static <T> RestResponse<T> error(RestCode code) {
        return new RestResponse<>(code.getCode(), code.getMsg());
    }

    public RestResponse() {
        this(RestCode.OK.getCode(), RestCode.OK.getMsg());
    }

    public RestResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }



}
