package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.model.dto.device.AddDeviceRequest;
import com.zjud.model.dto.device.UpdateDeviceRequest;
import com.zjud.model.entity.Device;
import com.zjud.model.entity.DeviceType;
import com.zjud.model.entity.Lab;
import com.zjud.model.vo.DeviceInfoVO;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.DeviceService;
import com.zjud.mapper.DeviceMapper;
import com.zjud.service.DeviceTypeService;
import com.zjud.service.LabService;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 86178
* @description 针对表【device(设备信息表)】的数据库操作Service实现
* @createDate 2023-08-31 14:31:48
*/
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device>
    implements DeviceService{

    @Resource
    private DeviceTypeService deviceTypeService;

    @Resource
    private LabService labService;

    @Override
    public Response<Boolean> updateDevice(UpdateDeviceRequest updateDeviceRequest) {
        Device device = BeanUtil.copyProperties(updateDeviceRequest, Device.class);
        boolean update = updateById(device);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> addDevice(AddDeviceRequest addDeviceRequest) {
        Device device = BeanUtil.copyProperties(addDeviceRequest, Device.class);
        boolean save = save(device);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> removeDevice(Long id) {
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<DeviceInfoVO>> getDeviceList() {
        List<Device> deviceList = list();
        List<DeviceInfoVO> list = new ArrayList<>();
        for (Device device : deviceList) {
            DeviceType deviceType = deviceTypeService.getById(device.getDeviceTypeId());
            Lab lab = labService.getById(device.getLabId());
            DeviceInfoVO deviceInfoVO = BeanUtil.copyProperties(device, DeviceInfoVO.class);
            deviceInfoVO.setLab(lab);
            deviceInfoVO.setDeviceType(deviceType);
            list.add(deviceInfoVO);
        }
        return ResultUtils.success(list);
    }

    @Override
    public DeviceInfoVO getDeviceInfoVOById(Long deviceId) {
        Device device = getById(deviceId);
        DeviceType deviceType = deviceTypeService.getById(device.getDeviceTypeId());
        Lab lab = labService.getById(device.getLabId());
        DeviceInfoVO deviceInfoVO = BeanUtil.copyProperties(device, DeviceInfoVO.class);
        deviceInfoVO.setLab(lab);
        deviceInfoVO.setDeviceType(deviceType);
        return deviceInfoVO;
    }
}




