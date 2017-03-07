package cn.athinbly.mybatisextend.commonmapper.mapping;

import java.util.*;

/**
 * dto¿‡–≈œ¢°£
 * Created by fenggqc on 2016/12/27.
 */
public class DtoTypeInfo {

    private Class dtoClass=null;


    private List<DtoFieldInfo> fields=new ArrayList<DtoFieldInfo>();

    /**
     * table name ,especially for insert ,update ,delete.
     */
    private String tableName="";




    /**
     * the query sql.like 'select a,b from d '
     */
    private String selectSqlStr="";

    /**
     * the cache of  insert sql.
     */
    private static Map<String,String> insertSqlCache= Collections.synchronizedMap( new HashMap<String, String>());



    public  DtoTypeInfo(Class dtoClass){
        this.dtoClass=dtoClass;
        //Collections.sort(this.fields);
    }




    /**
     * is one table mapper type ?
     */
    private  Boolean isSimpleTable=true;

    //region Getter And Setter


    public List<DtoFieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<DtoFieldInfo> fields) {
        this.fields = fields;
    }

    public static Map<String, String> getInsertSqlCache() {
        return insertSqlCache;
    }

    public static void setInsertSqlCache(Map<String, String> insertSqlCache) {
        DtoTypeInfo.insertSqlCache = insertSqlCache;
    }

    public String getSelectSqlStr() {
        return selectSqlStr;
    }

    public void setSelectSqlStr(String selectSqlStr) {
        this.selectSqlStr = selectSqlStr;
    }

    public Boolean getIsSimpleTable() {
        return isSimpleTable;
    }

    public void setIsSimpleTable(Boolean isSimpleTable) {
        this.isSimpleTable = isSimpleTable;
    }




    public String getTableName() {

        if (this.tableName.length()==0){
            return this.dtoClass.getSimpleName();
        }
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    // endregion

}
