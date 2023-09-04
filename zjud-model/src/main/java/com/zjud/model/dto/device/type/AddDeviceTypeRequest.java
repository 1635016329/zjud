package com.zjud.model.dto.device.type;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 9:18
 * @description 添加设备分类请求
 */
@Data
public class AddDeviceTypeRequest {

    @NotBlank
    private String typeName;
}
