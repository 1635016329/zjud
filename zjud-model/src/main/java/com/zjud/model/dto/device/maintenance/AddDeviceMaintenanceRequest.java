package com.zjud.model.dto.device.maintenance;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 9:33
 * @description 添加设备维护请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceMaintenanceRequest {

    /**
     * 设备id
     */
    @NonNull
    private Long deviceId;

    /**
     * 维护人员列表，用英文,分隔
     */
    @NonNull
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
     * 开始时间
     */
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 预期结束时间
     */
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedEndTime;
}
