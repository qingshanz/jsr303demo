/**
 * @(#)IsMobileValidator, 2020年04月05日.
 */
package com.example.jsr303demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.example.jsr303demo.ano.IsMobile;
import com.example.jsr303demo.utils.ValidatorUtil;

/**
 * @author qingshanz
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {
    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            //调用第3步 中的校验类的校验方法进行判断是否是手机号
            return ValidatorUtil.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}