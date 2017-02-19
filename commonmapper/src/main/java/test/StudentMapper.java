package test;

import org.apache.ibatis.annotations.Param;

/**
 * Created by fenggqc on 2017/2/18.
 */
public interface StudentMapper {

    Student SelectOne(@Param("id") Integer id);

}
