package com.example.hyy.practice.circle.di;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName ClassA
 * @Author 18845
 * @Date 2021/12/2 15:46
 * @Description ClassA
 * @Version 1.0
 */
@Component
public class ClassB {

    @Resource
    private ClassB classA;
}
