package com.imook.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: concurency
 * @Package: com.imook.study.annotation
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/4 1:01 PM
 * @Version: v1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {

    String value() default "";
}
