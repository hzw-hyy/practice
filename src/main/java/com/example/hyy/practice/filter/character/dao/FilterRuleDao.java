package com.example.hyy.practice.filter.character.dao;

import com.bosssoft.gp.framework.mybatis.plus.dao.PlatDao;
import com.example.hyy.practice.filter.character.model.FilterRuleModel;
import com.example.hyy.practice.filter.character.vo.FilterCharacterPageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName FilterRuleDao
 * @Author 18845
 * @Date 2021/10/24 12:25
 * @Description FilterRuleDao
 * @Version 1.0
 */
@Repository
public interface FilterRuleDao extends PlatDao<FilterRuleModel> {

    List<FilterRuleModel> selectFilterRule(@Param("filterCharacterPageVo") FilterCharacterPageVo filterCharacterPageVo);

    List<FilterRuleModel> selectFilterRuleTwo();

}
