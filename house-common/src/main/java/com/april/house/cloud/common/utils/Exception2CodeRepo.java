package com.april.house.cloud.common.utils;

import com.april.house.cloud.common.enums.RestCode;
import com.april.house.cloud.common.exception.WithTypeException;
import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * @Creation :  2018-12-24 18:05
 * --------  ---------  --------------------------
 */
public class Exception2CodeRepo {
    public static RestCode getCode(Throwable throwable) {
        if (throwable == null) {
            return RestCode.UNKOWN_ERROR;
        }

        if (throwable.getClass().isAssignableFrom(WithTypeException.class) ) {
            return ((WithTypeException) throwable).getRestCode();
        }

        Throwable rootCause = ExceptionUtils.getRootCause(throwable);
        if (rootCause != null) {
            return getCode(rootCause);
        }
        return RestCode.UNKOWN_ERROR;

    }
}
