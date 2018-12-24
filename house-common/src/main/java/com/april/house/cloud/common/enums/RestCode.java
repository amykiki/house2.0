package com.april.house.cloud.common.enums;

import lombok.Getter;

/**
 * @Creation :  2018-12-24 17:43
 * --------  ---------  --------------------------
 */
@Getter
public enum RestCode {
    OK(0, "ok"),
    UNKOWN_ERROR(1, "未知异常"),
    WRONG_PAGE(2, "页码不合法"),
    LACK_PARAMS(3, "缺少参数");

    private final int code;
    private final String msg;

    RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
