package com.example.hyy.practice.filter.character.service;

import com.example.hyy.practice.filter.character.model.FilterCharacterModel;
import com.example.hyy.practice.filter.character.model.FilterRuleModel;
import com.example.hyy.practice.filter.character.vo.FilterCharacterPageVo;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符过滤类
 *
 * @ClassName ParaCheckService
 * @Author 18845
 * @Date 2021/10/24 13:13
 * @Description ParaCheckService
 * @Version 1.0
 */
@Slf4j
@Service
public class ParaCheckService {

    @Resource
    private FilterRuleService filterRuleService;

    public String filterValue(String userPath, String value) {
        FilterCharacterPageVo filterCharacterPageVo = new FilterCharacterPageVo();
        filterCharacterPageVo.setPageNumber(1);
        filterCharacterPageVo.setPageSize(10);
        filterCharacterPageVo.setSortOrder("rule_code ASC");
        filterCharacterPageVo.setUserPath(userPath);
        PageInfo<FilterRuleModel> filterRule = filterRuleService.findFilterRule(filterCharacterPageVo);
        List<FilterRuleModel> list = filterRule.getList();
        Set<Pattern> patterns = Sets.newHashSet();
        for (FilterRuleModel filterRuleModel : list) {
            List<FilterCharacterModel> filterCharacter = filterRuleModel.getFilterCharacterModels();
            for (FilterCharacterModel ruleModel : filterCharacter) {
                String character = ruleModel.getFilterCharacter();
                if (!patterns.stream().anyMatch(pattern -> pattern.pattern().equalsIgnoreCase(character))) {
                    Pattern pattern = Pattern.compile(character, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
                    patterns.add(pattern);
                }
            }
        }
        String strClean = strClean(patterns, value);
        return strClean;
    }

    /**
     * 清除会引入XSS漏洞的字符
     *
     * @param value
     * @return
     */
    private String strClean(Set<Pattern> patterns, String value) {
        String str = value;
        log.info("Xss需要被过滤的值：{}", str);
        if (null != value && !"".equalsIgnoreCase(value)) {
            for (Pattern pattern : patterns) {
                Matcher matcher = pattern.matcher(value);
                boolean isFind = matcher.find();
                if (isFind) {
                    value = matcher.replaceAll("");
                    log.info("过滤规则：{}_被过滤字符串：{}_过滤后字符串：{}", matcher.pattern().pattern(), str, value);
                }
            }
        }
        return value;
    }
}
