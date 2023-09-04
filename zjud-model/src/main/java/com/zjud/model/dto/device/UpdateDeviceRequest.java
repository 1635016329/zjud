package com.zjud.model.dto.device;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 9:53
 * @description 更新设备请求
 */
@Data
public class UpdateDeviceRequest {
    /**
     * 设备id
     */
    @NotNull
    private Long deviceId;

    /**
     * 设备分类id
     */
    @NotNull
    private Long deviceTypeId;

    /**
     * 设备名称
     */
    @NotBlank
    private String deviceName;

    /**
     * 所属实验室
     */
    @NotNull
    private Long labId;

    /**
     * 设备功能
     */
    @NotBlank
    private String deviceFunc;

    /**
     * 设备使用说明书存储路径
     */
    @NotBlank
    private String operationInstructionUrl;

    /**
     * 是否被使用 0 不是， 1 是
     */
    @NotNull
    private Integer isInUse;

    /**
     * 是否被维护 0 不是， 1 是
     */
    @NotNull
    private Integer isUnderMaintenance;
}
