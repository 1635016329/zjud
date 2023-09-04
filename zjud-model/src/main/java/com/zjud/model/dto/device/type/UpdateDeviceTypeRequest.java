package com.zjud.model.dto.device.type;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 9:20
 * @description 修改设备分类请求
 */
@Data
public class UpdateDeviceTypeRequest {
    /**
     * 设备分类id
     */
    @NotNull
    private Long deviceTypeId;

    /**
     * 设备分类名称
     */
    @NotBlank
    private String typeName;
}
