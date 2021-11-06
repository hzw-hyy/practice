package com.example.hyy.practice.filter.character.service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.hyy.practice.filter.character.dao.FilterRuleDao;
import com.example.hyy.practice.filter.character.model.FilterRuleModel;
import com.example.hyy.practice.filter.character.vo.FilterCharacterPageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName FilterRuleService
 * @Author 18845
 * @Date 2021/10/24 12:26
 * @Description FilterRuleService
 * @Version 1.0
 */
@Service
public class FilterRuleService {

    @Resource
    FilterRuleDao filterRuleDao;

    /**
     * 根据规则编码查找过滤字符
     */
    public PageInfo<FilterRuleModel> findFilterRule(FilterCharacterPageVo filterCharacterPageVo) {
        Integer pageIndex = filterCharacterPageVo.getPageNumber();
        Integer pageSize = filterCharacterPageVo.getPageSize();
        String orderBy = filterCharacterPageVo.getSortOrder();
        //分页信息
        PageHelper.startPage(pageIndex, pageSize, orderBy);
        List<FilterRuleModel> filterRuleModels = filterRuleDao.selectFilterRule(filterCharacterPageVo);
        PageInfo<FilterRuleModel> pageInfo = new PageInfo<FilterRuleModel>(filterRuleModels);
        return pageInfo;
    }
}
