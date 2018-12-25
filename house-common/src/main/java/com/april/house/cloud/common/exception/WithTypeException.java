package com.april.house.cloud.common.exception;

import com.april.house.cloud.common.enums.RestCode;

public class WithTypeException extends RuntimeException {
    private RestCode restCode;

    public WithTypeException(String message, RestCode restCode) {
        super(message);
        this.restCode = restCode;
    }

    public WithTypeException(String message) {
        super(message);
        this.restCode = RestCode.LACK_PARAMS;
    }

    public RestCode getRestCode() {
        return restCode;
    }
}
