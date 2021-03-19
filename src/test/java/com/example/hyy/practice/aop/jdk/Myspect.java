package com.example.hyy.practice.aop.jdk;

public class Myspect {

    public void pre() {
        System.out.println("before...");
    }

    public void next() {
        System.out.println("after...");
    }
}
