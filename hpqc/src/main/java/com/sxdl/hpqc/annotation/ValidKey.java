package com.sxdl.hpqc.annotation;


import com.sxdl.hpqc.util.MyConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy= MyConstraint.class)
public @interface ValidKey {

    String message() default "非法操作: 验证码检验失败!!!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
