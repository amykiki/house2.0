package com.april.house.cloud.common.exception;

public class RestException extends RuntimeException{
    private static final long serialVersionUID = 4068398851845011034L;

    public RestException(String errorCode) {
        super(errorCode);
    }

    public RestException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public RestException(Throwable cause) {
        super(cause);
    }

    public RestException(String errorCode, String errorMsg) {
        super(errorCode + ":" + errorMsg);
    }

    public RestException(String errorCode, String errorMsg, Throwable throwable) {
        super(errorCode + ":" + errorMsg, throwable);
    }
}
