package cn.athinbly.mybatisextend.commonmapper.mapper;


import cn.athinbly.mybatisextend.commonmapper.sqlprovider.insert.CustomInsertProvider;
import cn.athinbly.mybatisextend.commonmapper.sqlprovider.select.CustomSelectProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;


import java.util.List;
import java.util.Map;

/**
 * Created by fenggqc on 2016/12/16.
 */

public interface CommonMapper<T> {


    @SelectProvider(type = CustomSelectProvider.class, method = "BuildSelect")
    <T> List<Map<String, Object>> SelectByPrimaryKey(@Param("dto") T t);


    @org.apache.ibatis.annotations.InsertProvider(type = CustomInsertProvider.class, method = "BuildInsert")
    void Insert(@Param("dto") T t);


}
