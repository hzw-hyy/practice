package com.example.hyy.practice.config;

import com.example.hyy.practice.filter.character.service.ParaCheckService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yggc
 */
@Configuration
@ConditionalOnProperty(value = "gp.framework.filter.character.enable", havingValue = "true")
@MapperScan("com.example.hyy.practice.filter.character.dao")
@ComponentScan("com.example.hyy.practice")
public class AutoConfig {

}