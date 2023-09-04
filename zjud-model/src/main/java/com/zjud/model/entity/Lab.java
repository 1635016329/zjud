package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 实验室表
 * @TableName lab
 */
@TableName(value ="lab")
@Data
public class Lab implements Serializable {
    /**
     * 实验室id
     */
    @TableId(type = IdType.AUTO)
    private Long labId;

    /**
     * 实验室名称
     */
    private String labName;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 实验室布局
     */
    private String layout;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}