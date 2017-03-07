package cn.athinbly.mybatisextend.commonmapper.annotation;

import java.lang.annotation.*;

/**
 *indiciate the field value will be setted through computer when insert or update.
 * Created by fenggqc on 2017/2/16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ComputerVale {

    //region Getter And Setter
    // endregion

}
