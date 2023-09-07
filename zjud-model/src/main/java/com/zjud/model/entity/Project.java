package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目管理表
 * @TableName project
 */
@TableName(value ="project")
@Data
public class Project implements Serializable {
    /**
     * 项目id
     */
    @TableId(type = IdType.AUTO)
    private Long projectId;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 项目分类
     */
    private Long projectTypeId;

    /**
     * 项目目的
     */
    private String target;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}