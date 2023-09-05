package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.model.dto.device.order.AddDeviceOrderRequest;
import com.zjud.model.dto.device.order.UpdateDeviceOrderByUserRequest;
import com.zjud.model.dto.device.order.UpdateDeviceOrderRequest;
import com.zjud.model.entity.*;
import com.zjud.model.vo.DeviceInfoVO;
import com.zjud.model.vo.DeviceOrderVO;
import com.zjud.model.vo.UserVO;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.DeviceOrderService;
import com.zjud.mapper.DeviceOrderMapper;
import com.zjud.service.DeviceService;
import com.zjud.service.UserService;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import com.zjud.util.TokenThreadLocal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 86178
* @description 针对表【device_order(设备预约表)】的数据库操作Service实现
* @createDate 2023-08-31 14:31:48
*/
@Service
public class DeviceOrderServiceImpl extends ServiceImpl<DeviceOrderMapper, DeviceOrder>
    implements DeviceOrderService{

    @Resource
    private UserService userService;

    @Resource
    private DeviceService deviceService;

    @Override
    public Response<Boolean> removeOrder(Long id) {
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> addOrder(AddDeviceOrderRequest addDeviceOrderRequest) {
        DeviceOrder deviceOrder = BeanUtil.copyProperties(addDeviceOrderRequest, DeviceOrder.class);
        Long userId = Convert.toLong(JWTUtil.parseToken(TokenThreadLocal.getToken()).getPayload("userId"));
        deviceOrder.setUserId(userId);
        boolean save = save(deviceOrder);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> updateOrder(UpdateDeviceOrderRequest updateDeviceOrderRequest) {
        DeviceOrder deviceOrder = BeanUtil.copyProperties(updateDeviceOrderRequest, DeviceOrder.class);
        UpdateWrapper<DeviceOrder> deviceOrderUpdateWrapper = new UpdateWrapper<>();
        deviceOrderUpdateWrapper.eq("order_id", deviceOrder.getOrderId())
                .set("user_id", deviceOrder.getUserId())
                .set("order_state", deviceOrder.getOrderState())
                .set("start_time", deviceOrder.getStartTime())
                .set("end_time", deviceOrder.getEndTime())
                .set("device_id", deviceOrder.getDeviceId());
        boolean update = update(deviceOrderUpdateWrapper);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<DeviceOrderVO>> getOrderList() {
        QueryWrapper<DeviceOrder> deviceOrderQueryWrapper = new QueryWrapper<>();
        deviceOrderQueryWrapper.orderByDesc("create_time");
        List<DeviceOrder> orders = list(deviceOrderQueryWrapper);
        List<DeviceOrderVO> list = parseDeviceOrderVOList(orders);
        return ResultUtils.success(list);
    }

    @Override
    public Response<Boolean> updateOrderByUser(UpdateDeviceOrderByUserRequest updateDeviceOrderByUserRequest) {
        DeviceOrder deviceOrder = BeanUtil.copyProperties(updateDeviceOrderByUserRequest, DeviceOrder.class);
        Long userId = Convert.toLong(JWTUtil.parseToken(TokenThreadLocal.getToken()).getPayload("userId"));
        UpdateWrapper<DeviceOrder> deviceOrderUpdateWrapper = new UpdateWrapper<>();
        deviceOrderUpdateWrapper.eq("order_id", deviceOrder.getOrderId())
                .eq("user_id", userId)
                .set("start_time", deviceOrder.getStartTime())
                .set("end_time", deviceOrder.getEndTime())
                .set("device_id", deviceOrder.getDeviceId());
        boolean update = updateById(deviceOrder);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<DeviceOrderVO>> myOrders() {
        Long userId = Convert.toLong(JWTUtil.parseToken(TokenThreadLocal.getToken()).getPayload("userId"));
        QueryWrapper<DeviceOrder> deviceOrderQueryWrapper = new QueryWrapper<>();
        deviceOrderQueryWrapper.eq("user_id", userId)
                .orderByDesc("create_time");
        List<DeviceOrder> orders = list(deviceOrderQueryWrapper);
        List<DeviceOrderVO> list = parseDeviceOrderVOList(orders);
        return ResultUtils.success(list);
    }

    @Override
    public Response<List<DeviceOrderVO>> getDeviceOrderListById(Long id) {
        QueryWrapper<DeviceOrder> deviceOrderQueryWrapper = new QueryWrapper<>();
        deviceOrderQueryWrapper.eq("device_id", id)
                .orderByDesc("create_time");
        List<DeviceOrder> orders = list(deviceOrderQueryWrapper);
        List<DeviceOrderVO> list = parseDeviceOrderVOList(orders);
        return ResultUtils.success(list);
    }

    /**
     * 将orders转化为orderVOs
     * @param orders
     * @return
     */
    private List<DeviceOrderVO> parseDeviceOrderVOList(List<DeviceOrder> orders) {
        List<DeviceOrderVO> list = new ArrayList<>();
        for (DeviceOrder order : orders) {
            DeviceOrderVO deviceOrderVO = BeanUtil.copyProperties(order, DeviceOrderVO.class);
            DeviceInfoVO deviceInfoVO = deviceService.getDeviceInfoVOById(order.getDeviceId());
            User user = userService.getById(order.getUserId());
            UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
            deviceOrderVO.setUserVO(userVO);
            deviceOrderVO.setDeviceInfoVO(deviceInfoVO);
            list.add(deviceOrderVO);
        }
        return list;
    }
}




