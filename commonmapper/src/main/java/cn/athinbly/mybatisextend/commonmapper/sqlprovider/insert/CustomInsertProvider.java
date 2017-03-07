package cn.athinbly.mybatisextend.commonmapper.sqlprovider.insert;

import cn.athinbly.mybatisextend.commonmapper.mapping.DtoFieldInfo;
import cn.athinbly.mybatisextend.commonmapper.mapping.DtoTypeInfo;
import cn.athinbly.mybatisextend.commonmapper.reflection.wrapper.DtoTypeWrapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.Student;

import java.util.List;

/**
 * Created by fenggqc on 2017/3/2.
 */
public class CustomInsertProvider {

    //region Getter And Setter
    // endregion


    private Logger logger = LoggerFactory.getLogger(CustomInsertProvider.class);

    public <T> String BuildInsert(T t) throws Exception {
        try {
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) t;
            Object para = paramMap.get("dto");

            DtoTypeInfo dtoTypeInfo = DtoTypeWrapper.TrimType(para.getClass());
            List<DtoFieldInfo> fieldInfos = dtoTypeInfo.getFields();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  INSERT INTO ").append("").append(dtoTypeInfo.getTableName()).append("(");
            StringBuilder stringBuilderWhere = new StringBuilder();
            Object value;
            boolean hasappend=false;
            for (int i = 0; i < fieldInfos.size(); i++) {
                fieldInfos.get(i).getField().setAccessible(true);
                value = fieldInfos.get(i).getField().get(para);

                if (value == null) {
                    continue;
                }
                if (true==hasappend){
                    stringBuilder.append(",");
                    stringBuilderWhere.append(",");
                }


                stringBuilder.append(fieldInfos.get(i).getColName());
                stringBuilderWhere.append("#{dto.").append(fieldInfos.get(i).getField().getName()).append("}");
                hasappend=true;
            }

            if (false==hasappend){
                throw new IllegalArgumentException("all fields are null!");
            }


            stringBuilder.append(")");
            stringBuilderWhere.append(")");


            stringBuilder.append(" Values( ");
            stringBuilder.append(stringBuilderWhere.toString());
            logger.debug(stringBuilder.toString());

            return stringBuilder.toString();
            //  return "INSERT INTO Student(id,name,male) VALUES( #{dto.id},#{dto.name},#{dto.male} );";
        } catch (Exception ex) {
            logger.error(ExceptionUtils.getStackTrace(ex));
            throw ex;
        }


    }

}
