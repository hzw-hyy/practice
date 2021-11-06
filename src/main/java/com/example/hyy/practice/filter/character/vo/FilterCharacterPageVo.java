package com.example.hyy.practice.filter.character.vo;

import com.bosssoft.gp.framework.base.vo.BasePageVo;
import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * @ClassName FilterCharacterPageVo
 * @Author 18845
 * @Date 2021/10/24 12:57
 * @Description FilterCharacterPageVo
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class FilterCharacterPageVo extends BasePageVo {


    /**
     * 查询编码
     */
    private String userPath;

}
