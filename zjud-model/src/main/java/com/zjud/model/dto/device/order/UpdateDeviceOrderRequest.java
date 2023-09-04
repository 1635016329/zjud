package com.zjud.model.dto.device.order;

import lombok.Data;

import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 11:02
 * @description
 */
@Data
public class UpdateDeviceOrderRequest {
    /**
     * 设备预约id
     */
    private Long orderId;

    /**
     * 预约用户id
     */
    private Long userId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 预约状态：0 未审核 1 审核通过 2 审核未通过 3 正在生效 4 过期
     */
    private Integer orderState;

    /**
     *
     */
    private Long deviceId;
}
