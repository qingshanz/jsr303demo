/**
 * @(#)ListNotHasNullValidatorImpl, 2020年04月06日.
 */
package com.example.jsr303demo.validator;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.jsr303demo.ano.ListNotHasNull;

/**
 * @author qingshanz
 */
public class ListNotHasNullValidatorImpl implements ConstraintValidator<ListNotHasNull, List> {
    private int value;

    @Override
    public void initialize(ListNotHasNull constraintAnnotation) {
        //传入value 值，可以在校验中使用
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        if (value != 0) {
            return true;
        }

        for (Object object : list) {
            if (object == null) {
                //如果List集合中含有Null元素，校验失败
                return false;
            }
        }
        return true;
    }
}