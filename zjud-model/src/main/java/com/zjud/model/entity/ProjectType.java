package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 项目分类表
 * @TableName project_type
 */
@TableName(value ="project_type")
@Data
public class ProjectType implements Serializable {
    /**
     * 项目分类id
     */
    @TableId(type = IdType.AUTO)
    private Long projectTypeId;

    /**
     * 分类名
     */
    private String typeName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}