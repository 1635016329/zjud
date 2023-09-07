package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 项目用户联系表
 * @TableName project_user
 */
@TableName(value ="project_user")
@Data
public class ProjectUser implements Serializable {
    /**
     * 项目用户联系id
     */
    @TableId(type = IdType.AUTO)
    private Long projectUserId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 所属成员id
     */
    private Long userId;

    /**
     * 项目组成员职责
     */
    private Integer userJob;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}