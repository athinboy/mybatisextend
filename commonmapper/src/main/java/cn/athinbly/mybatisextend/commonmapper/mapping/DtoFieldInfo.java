package cn.athinbly.mybatisextend.commonmapper.mapping;


import java.lang.reflect.Field;
import org.apache.ibatis.type.JdbcType;

/**
 *
 * Created by fenggqc on 2017/2/16.
 */
public class DtoFieldInfo  implements  java.lang.Comparable<DtoFieldInfo> {

    /**
     * the field of the dto class;
     */
    private Field field;

    private  JdbcType jdbcType= JdbcType.UNDEFINED;

    private String colName="";

    private  Boolean whetherPrimaryKey =false;

    private  Boolean whetherAlaysNow=false;



    public DtoFieldInfo(Field field)
    {
        this.field=field;
    }

    //region Getter And Setter




    public String getColName() {

        if (this.colName==null || this.colName.length()==0){
            this.colName=this.field.getName();
        }
        return colName;
    }

    public void setColName(String colName) {

        this.colName = colName;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JdbcType jdbcType) {
        this.jdbcType = jdbcType;
    }

    public Boolean getWhetherAlaysNow() {
        return whetherAlaysNow;
    }

    public void setWhetherAlaysNow(Boolean whetherAlaysNow) {
        this.whetherAlaysNow = whetherAlaysNow;
    }

    public Boolean getWhetherPrimaryKey() {
        return whetherPrimaryKey;
    }

    public void setWhetherPrimaryKey(Boolean whetherPrimaryKey) {
        this.whetherPrimaryKey = whetherPrimaryKey;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }





    // endregion




    //region function

    /**
     *compare for sort purpose.
     * @param o
     * @return
     */
    public int compareTo(DtoFieldInfo o) {

        return this.field.getName().compareToIgnoreCase(o.getField().getName());
    }


    // endregion

}
