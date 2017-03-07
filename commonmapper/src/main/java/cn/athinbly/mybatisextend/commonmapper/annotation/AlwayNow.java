package cn.athinbly.mybatisextend.commonmapper.annotation;

import java.lang.annotation.*;

/**
 *
 * indicate the field will be setted with current time when insert or update .
 *
 * Created by fenggqc on 2017/2/24.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface AlwayNow {

}
