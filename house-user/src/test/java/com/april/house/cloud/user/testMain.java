package com.april.house.cloud.user;

import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

public class testMain {
    public static void main(String[] args) {
        final ParameterizedTypeReference<List<String>> parameterizedTypeReference = new ParameterizedTypeReference<List<String>>() {
        };

        System.out.println(parameterizedTypeReference.getType());
    }
}

