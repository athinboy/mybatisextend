package test;

import cn.athinbly.mybatisextend.commonmapper.annotation.STDto;

/**
 * Created by fenggqc on 2017/2/18.
 */
@STDto()
public class Student {


    private Integer id;
    private  String name;
    private Boolean male;

    //region Getter And Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // endregion

}
