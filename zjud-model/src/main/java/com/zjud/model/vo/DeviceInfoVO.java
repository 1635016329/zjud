package com.zjud.model.vo;

import com.zjud.model.entity.DeviceType;
import com.zjud.model.entity.Lab;
import lombok.Data;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 9:57
 * @description
 */
@Data
public class DeviceInfoVO {
    /**
     * 设备id
     */
    private Long deviceId;

    /**
     * 设备分类
     */
    private DeviceType deviceType;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 所属实验室
     */
    private Lab lab;

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
}
