package com.example.jsr303demo.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.fastjson.JSON;

@RestControllerAdvice
@Slf4j
public class GlobalController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage(), exception);
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> map = new HashMap<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(error -> {
                    map.put(error.getField(), error.getDefaultMessage());
                }
        );
        return JSON.toJSONString(map);
    }

    @ExceptionHandler(value = Exception.class)
    public String ExceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception);
        return JSON.toJSONString(exception.getMessage());
    }


}