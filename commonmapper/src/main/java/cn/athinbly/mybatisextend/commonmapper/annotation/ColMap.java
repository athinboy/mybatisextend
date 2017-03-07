package cn.athinbly.mybatisextend.commonmapper.annotation;

import org.apache.ibatis.type.JdbcType;

import java.lang.annotation.*;

/**
 * map info between  field and database column.
 * Created by fenggqc on 2017/2/28.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ColMap {


    String ColName() default "";

    JdbcType JdbcType() default JdbcType.UNDEFINED;

    ;

}

