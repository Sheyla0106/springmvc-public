package com.sheyla.springmvc.bean.enums;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 11:33
 * @Modified By：
 */
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩"),
    THREE(3, "燕");

    private Integer key;
    private String val;

    CountryEnum(Integer key, String val) {
        this.key = key;
        this.val = val;
    }

    public Integer getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }

    public static CountryEnum getById(int index){
        for (CountryEnum element : CountryEnum.values()) {
            if (element.key==index){
               return  element;
            }
        }

        return null;

    }

}
