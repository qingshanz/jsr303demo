/**
 * @(#)IndexController, 2020年04月05日.
 */
package com.example.jsr303demo.controller;


import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.jsr303demo.valid.AddGroup;
import com.example.jsr303demo.valid.QueryGroup;
import com.example.jsr303demo.vo.UserVO;

/**
 * @author qingshanz
 */
@RestController
@Validated
public class IndexController {


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String queryUser(@Validated({QueryGroup.class}) @RequestBody UserVO userVo) {

        return JSON.toJSONString(userVo);
    }

    // 分组校验
    @PostMapping("/add")
    public String addUser(@Validated({AddGroup.class, Default.class}) @RequestBody UserVO userVo) {

        return JSON.toJSONString(userVo);
    }

    //参数校验 1 @Validated 2 定义MethodValidationPostProcessor Bean
    @GetMapping("/name")
    public String nameCheck(@Length(min = 2) @RequestParam String name) {
        return name;
    }


}