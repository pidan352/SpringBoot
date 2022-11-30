package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProcessingType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long environmentalCompanyId;

    private Long wasteId;

    /**
     * 数据创建时间,在数据新增时设置
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 数据修改时间,在数据新增时和修改时设置
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private String delFlag;

    private String createBy;


}
