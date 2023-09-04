package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.model.dto.device.maintenance.AddDeviceMaintenanceRequest;
import com.zjud.model.dto.device.maintenance.UpdateDeviceMaintenanceRequest;
import com.zjud.model.entity.Device;
import com.zjud.model.entity.DeviceMaintenance;
import com.zjud.model.entity.DeviceType;
import com.zjud.model.entity.Lab;
import com.zjud.model.vo.DeviceInfoVO;
import com.zjud.model.vo.DeviceMaintenanceVO;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.DeviceMaintenanceService;
import com.zjud.mapper.DeviceMaintenanceMapper;
import com.zjud.service.DeviceService;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 86178
* @description 针对表【device_maintenance(设备维护表)】的数据库操作Service实现
* @createDate 2023-08-31 14:31:48
*/
@Service
public class DeviceMaintenanceServiceImpl extends ServiceImpl<DeviceMaintenanceMapper, DeviceMaintenance>
    implements DeviceMaintenanceService{

    @Resource
    private DeviceService deviceService;

    @Override
    public Response<Boolean> addMaintenance(AddDeviceMaintenanceRequest addDeviceMaintenanceRequest) {
        DeviceMaintenance deviceMaintenance = BeanUtil.copyProperties(addDeviceMaintenanceRequest, DeviceMaintenance.class);
        boolean save = save(deviceMaintenance);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> removeMaintenance(Long id) {
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> updateMaintenance(UpdateDeviceMaintenanceRequest updateDeviceMaintenanceRequest) {
        DeviceMaintenance deviceMaintenance = BeanUtil.copyProperties(updateDeviceMaintenanceRequest, DeviceMaintenance.class);
        boolean update = updateById(deviceMaintenance);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<DeviceMaintenanceVO>> getMaintenanceList() {
        List<DeviceMaintenance> deviceMaintenanceList = list();
        List<DeviceMaintenanceVO> list = new ArrayList<>();
        for (DeviceMaintenance deviceMaintenance : deviceMaintenanceList) {
            DeviceInfoVO deviceInfoVO = deviceService.getDeviceInfoVOById(deviceMaintenance.getDeviceId());
            DeviceMaintenanceVO deviceMaintenanceVO = BeanUtil.copyProperties(deviceMaintenance, DeviceMaintenanceVO.class);
            deviceMaintenanceVO.setDeviceInfoVO(deviceInfoVO);
            list.add(deviceMaintenanceVO);
        }
        return ResultUtils.success(list);
    }
}




