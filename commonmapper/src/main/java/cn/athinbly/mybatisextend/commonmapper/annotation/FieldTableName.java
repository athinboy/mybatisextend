package cn.athinbly.mybatisextend.commonmapper.annotation;

import java.lang.annotation.*;

/**
 * ��ʾ�ֶ������ı�����
 * Created by fenggqc on 2016/12/18.
 */
@Documented
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface FieldTableName  {
    String value();

}
