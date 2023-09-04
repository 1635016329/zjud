package com.zjud.service;

import com.zjud.model.dto.device.maintenance.AddDeviceMaintenanceRequest;
import com.zjud.model.dto.device.maintenance.UpdateDeviceMaintenanceRequest;
import com.zjud.model.entity.DeviceMaintenance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.model.entity.DeviceType;
import com.zjud.model.vo.DeviceMaintenanceVO;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【device_maintenance(设备维护表)】的数据库操作Service
* @createDate 2023-08-31 14:31:48
*/
public interface DeviceMaintenanceService extends IService<DeviceMaintenance> {

    /**
     * 添加设备维护记录
     * @param addDeviceMaintenanceRequest
     * @return
     */
    Response<Boolean> addMaintenance(AddDeviceMaintenanceRequest addDeviceMaintenanceRequest);

    /**
     * 移除设备维护记录
     * @param id
     * @return
     */
    Response<Boolean> removeMaintenance(Long id);

    /**
     * 更新设备维护记录
     * @param updateDeviceMaintenanceRequest
     * @return
     */
    Response<Boolean> updateMaintenance(UpdateDeviceMaintenanceRequest updateDeviceMaintenanceRequest);

    /**
     * 获取设备维护列表
     * @return
     */
    Response<List<DeviceMaintenanceVO>> getMaintenanceList();

}
