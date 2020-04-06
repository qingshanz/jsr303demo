/**
 * @(#)ValidatorUtil, 2020年04月05日.
 */
package com.example.jsr303demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * @author qingshanz
 */
public class ValidatorUtil {
    //一个简单的校验，主要是看效果，这里的正则不要介意
    private static final Pattern moblie_pattern = Pattern.compile("1\\d{10}");

    //StringUtils为commons包中工具类
    public static Boolean isMobile(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        //验证正则表达式，并返回ture/false
        Matcher m = moblie_pattern.matcher(str);
        return m.matches();
    }
}