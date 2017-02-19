package cn.athinbly.mybatisextend.commonmapper.reflection.wrapper;

import cn.athinbly.mybatisextend.commonmapper.mapping.DtoTypeInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by fenggqc on 2017/2/16.
 */
public class DtoFieldWrapper {


    public static void WrapperFiled(Field field, DtoTypeInfo dtoTypeInfo) {

        if ( field==null || dtoTypeInfo==null){
            throw new  RuntimeException("Argument can not be null!");
        }

        Annotation[] annotations = field.getAnnotations();





    }


    //region Getter And Setter
    // endregion

}
