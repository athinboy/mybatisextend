package cn.athinbly.mybatisextend.commonmapper.annotation;


import java.lang.annotation.*;

/**
 * 标示类对应的数据表。
 * Created by fenggqc on 2016/12/13.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface TableName {
    String Value() default ("");
}
