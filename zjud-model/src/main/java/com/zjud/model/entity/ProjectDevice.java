package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 项目设备联系表
 * @TableName project_device
 */
@TableName(value ="project_device")
@Data
public class ProjectDevice implements Serializable {
    /**
     * 项目设备联系id
     */
    @TableId(type = IdType.AUTO)
    private Long projectDeviceId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目使用设备id数组，使用英文逗号分隔
     */
    private String deviceIds;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}