package cn.athinbly.mybatisextend.commonmapper.reflection.wrapper;

import cn.athinbly.mybatisextend.commonmapper.annotation.MTDto;
import cn.athinbly.mybatisextend.commonmapper.annotation.SelectSql;
import cn.athinbly.mybatisextend.commonmapper.annotation.TableName;
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

    static void Reflect(Class type) {
        if (false == typecache.containsKey(type.getName())) {
            typecache.put(type.getName(), TrimType(type));
        }

    }


    public static DtoTypeInfo TrimType(Class type) {


        if (true == typecache.containsKey(type.getName())) {
            return typecache.get(type.getName());
        }

        DtoTypeInfo result = new DtoTypeInfo(type);

        Annotation[] annotations = type.getAnnotations();

        List<String> allTableNames = new ArrayList<String>();

        boolean simpletable = IsMultiJoinDto(annotations) == false;

        if (simpletable == false) {
            throw new Error("multi table dto is not support yet!");
        }

        result.setIsSimpleTable(simpletable);

        for (Annotation annotation : annotations) {
            if (SelectSql.class.isAssignableFrom(annotation.annotationType())) {
                result.setSelectSqlStr(((SelectSql) annotation).Value());

            }
            if (TableName.class.isAssignableFrom(annotation.annotationType())) {
                result.setTableName(((TableName) annotation).Value());
            }

        }

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            result.getFields().add(DtoFieldWrapper.WrapperFiled(field, result));
        }
        typecache.put(type.getName(), result);
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
