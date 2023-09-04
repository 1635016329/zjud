package com.zjud.service;

import com.zjud.model.dto.device.AddDeviceRequest;
import com.zjud.model.dto.device.UpdateDeviceRequest;
import com.zjud.model.entity.Device;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.model.vo.DeviceInfoVO;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【device(设备信息表)】的数据库操作Service
* @createDate 2023-08-31 14:31:48
*/
public interface DeviceService extends IService<Device> {

    /**
     * 更新设备信息
     * @param updateDeviceRequest
     * @return
     */
    Response<Boolean> updateDevice(UpdateDeviceRequest updateDeviceRequest);

    /**
     * 添加设备信息
     * @param addDeviceRequest
     * @return
     */
    Response<Boolean> addDevice(AddDeviceRequest addDeviceRequest);

    /**
     * 移除设备信息
     * @param id
     * @return
     */
    Response<Boolean> removeDevice(Long id);

    /**
     * 获取设备列表
     * @return
     */
    Response<List<DeviceInfoVO>> getDeviceList();

    /**
     * 根据id获取设备信息
     * @param deviceId
     * @return
     */
    DeviceInfoVO getDeviceInfoVOById(Long deviceId);
}
