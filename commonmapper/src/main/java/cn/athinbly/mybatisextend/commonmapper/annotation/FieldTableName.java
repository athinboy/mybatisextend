package cn.athinbly.mybatisextend.commonmapper.annotation;

import java.lang.annotation.*;

/**
 * 表示字段所属的表名。
 * Created by fenggqc on 2016/12/18.
 */
@Documented
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface FieldTableName  {
    String value();

}
