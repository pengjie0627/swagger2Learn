package com.example.demo.controller;

import com.example.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(description = "应付账单")
@RestController
public class SwaggerController {

    @ApiOperation("获取hello")
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }


    @ApiOperation("获取hello2")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String name) {
        return "hello";
    }

    @ApiOperation("获取用户")
    @PostMapping(value = "/user")
    public User user() {
        return new User();
    }
}
