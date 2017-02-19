package cn.athinbly.mybatisextend.commonmapper.reflection.wrapper;

import cn.athinbly.mybatisextend.commonmapper.annotation.MTDto;
import cn.athinbly.mybatisextend.commonmapper.mapping.DtoTypeInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 元数据反射。
 * Created by fenggqc on 2016/12/27.
 */
public class DtoTypeWrapper {


    private static Map<String, DtoTypeInfo> typecache = Collections.synchronizedMap(new HashMap<String, DtoTypeInfo>());

    public static void Reflect(Class type) {
        if (false == typecache.containsKey(type.getName())) {
            typecache.put(type.getName(), TrimType(type));
        }
    }


    private static DtoTypeInfo TrimType(Type type) {
        DtoTypeInfo result = new DtoTypeInfo();

        Annotation[] annotations = type.getClass().getAnnotations();

        List<String>allTableNames =new ArrayList<String>();

        boolean simpletable = IsMultiJoinDto(annotations) == false;

        if (simpletable == false) {
            throw new Error("multi table dto is not support yet!");
        }

        result.setIsSimpleTable(simpletable);

        for (Annotation annotation : annotations) {

        }
        Field[] fields = type.getClass().getFields();
        for (Field field : fields) {
            annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {

            }
        }


        return result;

    }


    /**
     * 是否多表连接Dto。
     *
     * @param annotations
     * @return
     */
    private static Boolean IsMultiJoinDto(Annotation[] annotations) {

        for (Annotation annotation : annotations) {
            if (annotation.getClass().isAnnotationPresent(MTDto.class)) {
                return true;
            }
        }
        return false;
    }


    //region Getter And Setter
    // endregion

}
