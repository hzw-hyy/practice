package com.example.hyy.practice.filter.character.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bosssoft.gp.framework.mybatis.plus.model.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName FilterUsePathModel
 * @Author 18845
 * @Date 2021/10/24 13:31
 * @Description FilterUsePathModel
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("filter_user_path")
public class FilterUsePathModel extends BaseModel {
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
     * 过滤路径
     */
    private String usePath;

}
