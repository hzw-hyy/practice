package com.example.hyy.practice.compare;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/6/29 16:49
 */
public class CompareDemo {
    public static void main(String[] args) {

        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(new Person("liubei","22","m"));
        peoples.add(new Person("guanyu","23","m"));
        peoples.add(new Person("zhangfei","21","m"));
        peoples.add(new Person("sunshangxiang","21","w"));
        Collections.sort(peoples);
        System.out.println(peoples.toString());


    }
}
