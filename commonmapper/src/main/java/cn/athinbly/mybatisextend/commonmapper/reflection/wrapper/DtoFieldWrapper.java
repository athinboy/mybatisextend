package cn.athinbly.mybatisextend.commonmapper.reflection.wrapper;

import cn.athinbly.mybatisextend.commonmapper.annotation.AlwayNow;
import cn.athinbly.mybatisextend.commonmapper.annotation.ColMap;
import cn.athinbly.mybatisextend.commonmapper.annotation.PrimaryKey;
import cn.athinbly.mybatisextend.commonmapper.mapping.DtoFieldInfo;
import cn.athinbly.mybatisextend.commonmapper.mapping.DtoTypeInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by fenggqc on 2017/2/16.
 */
public class DtoFieldWrapper {


    public static DtoFieldInfo WrapperFiled(Field field, DtoTypeInfo dtoTypeInfo) {


        if (field == null || dtoTypeInfo == null) {
            throw new RuntimeException("Argument can not be null!");
        }
        DtoFieldInfo dtoFieldInfo = new DtoFieldInfo(field);

        Annotation[] annotations = field.getAnnotations();

        for (Annotation annotation : annotations) {
            if (true == PrimaryKey.class.isAssignableFrom(annotation.annotationType())) {
                dtoFieldInfo.setWhetherPrimaryKey(true);
            }
            if (true == AlwayNow.class.isAssignableFrom(annotation.annotationType())) {
                dtoFieldInfo.setWhetherAlaysNow(true);
            }
            if (true == ColMap.class.isAssignableFrom(annotation.annotationType())) {

                ColMap colMap = (ColMap) annotation;
                dtoFieldInfo.setColName(colMap.ColName());
                dtoFieldInfo.setJdbcType(colMap.JdbcType());

            }

        }
        return dtoFieldInfo;


    }



    //region Getter And Setter
    // endregion

}
