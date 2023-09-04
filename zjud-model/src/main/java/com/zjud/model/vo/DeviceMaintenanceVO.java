package com.zjud.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 14:26
 * @description
 */
@Data
public class DeviceMaintenanceVO {
    /**
     * 设备维护id
     */
    private Long deviceMaintenanceId;

    /**
     * 设备id
     */
    private DeviceInfoVO deviceInfoVO;

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
}
