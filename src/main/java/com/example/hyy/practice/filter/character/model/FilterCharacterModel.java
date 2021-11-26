package com.example.hyy.practice.filter.character.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bosssoft.gp.framework.mybatis.plus.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName FilterCharacterModel
 * @Author 18845
 * @Date 2021/10/24 12:19
 * @Description FilterCharacterModel
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("filter_character")
public class FilterCharacterModel extends BaseModel {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 关联规则Id
     */
    private String ruleId;

    /**
     * 过滤字符串
     */
    private String filterCharacter;

}
