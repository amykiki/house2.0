package com.april.house.cloud.user.controller;

import com.april.house.cloud.common.model.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Value("${spring.profiles}")
    private String appProfile;

    @RequestMapping("getUserName")
    public RestResponse<String> getUserName(Long id) {
        return RestResponse.success(appProfile + "-" + id + "-test-username");
    }

}
