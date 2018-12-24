package com.april.house.cloud.common.exception;

import com.april.house.cloud.common.enums.RestCode;

/**
 * 包含类型的异常
 * @Creation :  2018-12-24 17:38
 * --------  ---------  --------------------------
 */
public interface WithTypeException {
    RestCode getRestCode();
}
