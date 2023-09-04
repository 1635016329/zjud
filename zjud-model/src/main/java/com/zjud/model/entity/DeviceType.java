package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 设备分类表
 * @TableName device_type
 */
@TableName(value ="device_type")
@Data
public class DeviceType implements Serializable {
    /**
     * 设备分类id
     */
    @TableId(type = IdType.AUTO)
    private Long deviceTypeId;

    /**
     * 设备分类名称
     */
    private String typeName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}