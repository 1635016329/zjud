package com.zjud.model.dto.device;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 9:47
 * @description 添加设备请求
 */
@Data
public class AddDeviceRequest {

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
     * 所属实验室id
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

}
