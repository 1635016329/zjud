package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 设备信息表
 * @TableName device
 */
@TableName(value ="device")
@Data
public class Device implements Serializable {
    /**
     * 设备id
     */
    @TableId(type = IdType.AUTO)
    private Long deviceId;

    /**
     * 设备分类id
     */
    private Long deviceTypeId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 所属实验室
     */
    private Long labId;

    /**
     * 设备功能
     */
    private String deviceFunc;

    /**
     * 设备使用说明书存储路径
     */
    private String operationInstructionUrl;

    /**
     * 是否被使用 0 不是， 1 是
     */
    private Integer isInUse;

    /**
     * 是否被维护 0 不是， 1 是
     */
    private Integer isUnderMaintenance;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}