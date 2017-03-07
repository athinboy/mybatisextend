package cn.athinbly.mybatisextend.commonmapper.sqlprovider.select;

import cn.athinbly.mybatisextend.commonmapper.annotation.MTDto;
import cn.athinbly.mybatisextend.commonmapper.annotation.STDto;
import cn.athinbly.mybatisextend.commonmapper.sqlprovider.select.IBuildSelectSql;
import cn.athinbly.mybatisextend.commonmapper.sqlprovider.select.SimplySelectSQLBuilder;

import java.lang.annotation.Annotation;

/**
 * Created by fenggqc on 2016/12/23.
 */
public class CustomSelectProvider {

    //region Getter And Setter
    // endregion


    public <T> String BuildSelect(T t) {
        Annotation[] annotations = t.getClass().getAnnotations();

        boolean simpletable = false;
        boolean multitable = false;
        for (Annotation annotation : annotations) {
            if (true == STDto.class.isAssignableFrom(annotation.annotationType())) {
                simpletable = true;
                break;
            }
            if (MTDto.class.isAnnotationPresent(annotation.getClass())) {
                multitable = true;
            }
        }
        IBuildSelectSql iBuildSelectSql;
        if (true == simpletable) {
            iBuildSelectSql = new SimplySelectSQLBuilder();
        } else {
            throw new Error("multi table join is not support yet!");
            //iBuildSelectSql=new JoinSelectSqlBuilder();
        }

        return iBuildSelectSql.BuildSelect(t);
    }


}
