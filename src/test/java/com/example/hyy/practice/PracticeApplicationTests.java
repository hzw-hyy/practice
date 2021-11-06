package com.example.hyy.practice;

import com.example.hyy.practice.filter.character.service.ParaCheckService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PracticeApplicationTests {

    @Resource
    private ParaCheckService paraCheckService;

    @Test
    void contextLoads() {
        System.out.println("test");
    }


    @Test
    void testFilterValue() {
        String value1 = paraCheckService.filterValue("/admin/cms/announcement.do", "<script>alert(11111)</script>");
        String value2 = paraCheckService.filterValue("/admin/cms/announcement.do", "onload111");
        String value3 = paraCheckService.filterValue("/admin/cms/announcement.do", "onerror(111)");
        String value4 = paraCheckService.filterValue("/admin/cms/announcement.do", "<scriptfsdafas>alert(11111)</script>");
        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);
        System.out.println("value3 = " + value3);
        System.out.println("value4 = " + value4);
    }

}
