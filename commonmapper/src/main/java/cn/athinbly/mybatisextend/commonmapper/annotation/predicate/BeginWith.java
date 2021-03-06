package cn.athinbly.mybatisextend.commonmapper.annotation.predicate;


import java.lang.annotation.*;

/**
 * begin with,translate to "like AA%"
 * Created by fenggqc on 2016/12/15.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BeginWith {

    String fieldname();

    //region Getter And Setter
    // endregion

}
