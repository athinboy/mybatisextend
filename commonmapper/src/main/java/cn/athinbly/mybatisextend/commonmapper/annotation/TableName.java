package cn.athinbly.mybatisextend.commonmapper.annotation;


import java.lang.annotation.*;

/**
 * ��ʾ���Ӧ�����ݱ�
 * Created by fenggqc on 2016/12/13.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface TableName {
    String Value() default ("");
}
