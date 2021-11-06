package com.example.hyy.practice.filter.character.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bosssoft.gp.framework.mybatis.plus.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

/**
 * @ClassName FilterRuleModel
 * @Author 18845
 * @Date 2021/10/24 12:21
 * @Description FilterRuleModel
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("filter_rule")
public class FilterRuleModel extends BaseModel {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 规则名称
     */
    private String ruleCode;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 使用路径
     */
    private List<FilterUsePathModel> filterUsePathModels;

    /**
     * 规则名称
     */
    private List<FilterCharacterModel> filterCharacterModels;
}
