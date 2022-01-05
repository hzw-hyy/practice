package com.example.hyy.practice.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName TestUtil
 * @Author yggc
 * @Date 2021-4-10 19:59
 * @Description TestUtil
 * @Version 1.0
 */
@Component
@Slf4j
public class TestUtil {

    private static TestUtil testUtil;

    @PostConstruct
    public void init() {
        testUtil = this;
    }
}
