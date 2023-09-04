package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.mapper.DeviceTypeMapper;
import com.zjud.model.dto.device.type.AddDeviceTypeRequest;
import com.zjud.model.dto.device.type.UpdateDeviceTypeRequest;
import com.zjud.model.entity.DeviceType;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.DeviceTypeService;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86178
* @description 针对表【device_type(设备分类表)】的数据库操作Service实现
* @createDate 2023-08-31 14:31:48
*/
@Service
public class DeviceTypeServiceImpl extends ServiceImpl<DeviceTypeMapper, DeviceType>
    implements DeviceTypeService{

    @Override
    public Response<Boolean> addType(AddDeviceTypeRequest addDeviceTypeRequest) {
        DeviceType deviceType = BeanUtil.copyProperties(addDeviceTypeRequest, DeviceType.class);
        boolean save = save(deviceType);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> removeType(Long id) {
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> updateType(UpdateDeviceTypeRequest updateDeviceTypeRequest) {
        DeviceType deviceType = BeanUtil.copyProperties(updateDeviceTypeRequest, DeviceType.class);
        boolean update = updateById(deviceType);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<DeviceType>> getTypeList() {
        List<DeviceType> list = list();
        return ResultUtils.success(list);
    }

}




