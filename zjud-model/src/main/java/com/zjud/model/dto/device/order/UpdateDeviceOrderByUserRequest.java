package com.zjud.model.dto.device.order;

import lombok.Data;

import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 15:03
 * @description
 */
@Data
public class UpdateDeviceOrderByUserRequest {
    /**
     * 设备预约id
     */
    private Long orderId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 设备id
     */
    private Long deviceId;
}
