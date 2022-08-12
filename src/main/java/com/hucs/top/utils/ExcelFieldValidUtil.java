package com.hucs.top.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * @description: excel 字段校验 返回错误信息
 * @author: huchuansai
 * @time: 2021/6/4 4:48 下午
 */
public class ExcelFieldValidUtil {
    // 校验信息
    public static String validParam(Object data) {
        StringBuilder result = new StringBuilder();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(data, Default.class);
        if (set != null && !set.isEmpty()) {
            for (ConstraintViolation<Object> cv : set) {
                //拼接错误信息，包含当前出错数据的标题名字+错误信息
                result.append(cv.getMessage()).append("；");
            }
        }
        return result.toString();
    }
}
