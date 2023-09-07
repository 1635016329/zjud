package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目成员申请表
 * @TableName project_user_application
 */
@TableName(value ="project_user_application")
@Data
public class ProjectUserApplication implements Serializable {
    /**
     * 申请id
     */
    @TableId(type = IdType.AUTO)
    private Long applicationId;

    /**
     * 申请项目id
     */
    private Long projectId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 申请状态
     */
    private Integer applicationStatus;

    /**
     * 
     */
    private String applicant;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}