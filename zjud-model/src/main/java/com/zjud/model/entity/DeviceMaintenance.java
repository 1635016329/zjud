package com.zjud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 设备维护表
 * @TableName device_maintenance
 */
@TableName(value ="device_maintenance")
@Data
public class DeviceMaintenance implements Serializable {
    /**
     * 设备维护id
     */
    @TableId(type = IdType.AUTO)
    private Long deviceMaintenanceId;

    /**
     * 设备id
     */
    private Long deviceId;

    /**
     * 维护人员列表，用英文,分隔
     */
    private String maintenanceStaff;

    /**
     * 维护内容
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date startTime;

    /**
     * 预期结束时间
     */
    private Date expectedEndTime;

    /**
     * 实际结束时间
     */
    private Date actualEndTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}