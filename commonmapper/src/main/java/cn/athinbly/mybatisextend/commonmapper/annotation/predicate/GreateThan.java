package cn.athinbly.mybatisextend.commonmapper.annotation.predicate;

import java.lang.annotation.*;

/**
 * GreateThan
 * Created by fenggqc on 2016/12/16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GreateThan {
    String fieldname();
}
