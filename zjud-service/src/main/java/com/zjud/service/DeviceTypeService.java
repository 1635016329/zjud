package com.zjud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.model.dto.device.type.AddDeviceTypeRequest;
import com.zjud.model.dto.device.type.UpdateDeviceTypeRequest;
import com.zjud.model.entity.DeviceType;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【device_type(设备分类表)】的数据库操作Service
* @createDate 2023-08-31 14:31:48
*/
public interface DeviceTypeService extends IService<DeviceType> {

    /**
     * 添加设备分类
     * @param addDeviceTypeRequest
     * @return
     */
    Response<Boolean> addType(AddDeviceTypeRequest addDeviceTypeRequest);

    /**
     * 删除单个设备分类
     * @param id
     * @return
     */
    Response<Boolean> removeType(Long id);

    /**
     * 更新设备分类
     * @param updateDeviceTypeRequest
     * @return
     */
    Response<Boolean> updateType(UpdateDeviceTypeRequest updateDeviceTypeRequest);

    /**
     * 获取设备分类列表
     * @return
     */
    Response<List<DeviceType>> getTypeList();

}
