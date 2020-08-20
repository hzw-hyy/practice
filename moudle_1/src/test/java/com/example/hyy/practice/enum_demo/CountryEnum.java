package com.example.hyy.practice.enum_demo;

import lombok.Getter;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/8/10 10:13
 */
public enum CountryEnum {

    One(1, "齐"),
    Two(2, "楚"),
    Thr(3, "燕"),
    Fou(4, "秦"),
    Fiv(5, "赵"),
    Six(6, "魏"),
    Sen(7, "韩");

    @Getter
    private Integer code;
    @Getter
    private String name;

    CountryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CountryEnum forEach(int index) {
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if (index == value.getCode()) {
                return value;
            }
        }
        return null;
    }
}
