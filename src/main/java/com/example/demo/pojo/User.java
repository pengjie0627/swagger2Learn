package com.example.demo.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
// @Api("用户实体类") 相当于 @ApiModel("用户实体类")
@Api("用户实体类")
public class User {
    @ApiModelProperty("用户id")
    private String id;
    @ApiModelProperty("用户名称")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
