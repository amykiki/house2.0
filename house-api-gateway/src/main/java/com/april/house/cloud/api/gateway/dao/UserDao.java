package com.april.house.cloud.api.gateway.dao;

import com.april.house.cloud.common.config.GenericRest;
import com.april.house.cloud.common.model.RestResponse;
import com.april.house.cloud.common.utils.RestUtil;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private GenericRest rest;

    @Value("${house.services.user}")
    private String userService;

    private String controllerName = "user";

    public String getUserName(Long id) {
        ImmutableMap<String, Object> params = ImmutableMap.<String, Object>builder()
                .put("id", id).build();
        String url = RestUtil.genGetRestUrl(userService, controllerName, "getUserName", params);
        RestResponse<String> response = rest.get(url, new ParameterizedTypeReference<RestResponse<String>>() {
        }).getBody();
        return response.getResult();
    }
}
