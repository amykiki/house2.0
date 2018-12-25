package com.april.house.cloud.api.gateway.controller;

import com.april.house.cloud.api.gateway.service.UserService;
import com.april.house.cloud.common.model.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class ApiController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUserName")
    public RestResponse<String> getUserName(Long id) {
        String userName = userService.getUserName(id);
        return RestResponse.success(userName);
    }

}
