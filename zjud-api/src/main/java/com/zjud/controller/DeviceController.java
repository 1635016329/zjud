package com.zjud.controller;

import com.zjud.model.dto.device.AddDeviceRequest;
import com.zjud.model.dto.device.order.AddDeviceOrderRequest;
import com.zjud.model.dto.device.order.UpdateDeviceOrderByUserRequest;
import com.zjud.model.dto.device.order.UpdateDeviceOrderRequest;
import com.zjud.model.vo.DeviceInfoVO;
import com.zjud.model.dto.device.UpdateDeviceRequest;
import com.zjud.model.dto.device.maintenance.AddDeviceMaintenanceRequest;
import com.zjud.model.dto.device.maintenance.UpdateDeviceMaintenanceRequest;
import com.zjud.model.dto.device.type.AddDeviceTypeRequest;
import com.zjud.model.dto.device.type.UpdateDeviceTypeRequest;
import com.zjud.model.entity.DeviceType;
import com.zjud.model.vo.DeviceMaintenanceVO;
import com.zjud.model.vo.DeviceOrderVO;
import com.zjud.response.Response;
import com.zjud.service.DeviceMaintenanceService;
import com.zjud.service.DeviceOrderService;
import com.zjud.service.DeviceService;
import com.zjud.service.DeviceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 9:03
 * @description 设备controller
 */
@RestController
@Api(tags = "设备接口")
@RequestMapping("/device")
public class DeviceController {

    @Resource
    private DeviceTypeService deviceTypeService;

    @Resource
    private DeviceMaintenanceService deviceMaintenanceService;

    @Resource
    private DeviceService deviceService;

    @Resource
    private DeviceOrderService deviceOrderService;

    @PostMapping("/type/admin/add")
    @ApiOperation("添加分类")
    public Response<Boolean> addType(@Validated @RequestBody AddDeviceTypeRequest addDeviceTypeRequest) {
        return deviceTypeService.addType(addDeviceTypeRequest);
    }

    @ApiOperation("删除分类")
    @DeleteMapping("/type/admin/remove/{id}")
    public Response<Boolean> removeType(@PathVariable Long id) {
        return deviceTypeService.removeType(id);
    }

    @ApiOperation("更新分类")
    @PutMapping("/type/admin/update")
    public Response<Boolean> updateType(@Validated @RequestBody UpdateDeviceTypeRequest updateDeviceTypeRequest) {
        return deviceTypeService.updateType(updateDeviceTypeRequest);
    }

    @ApiOperation("获取分类列表")
    @GetMapping("/type/admin/list")
    public Response<List<DeviceType>> getTypeList() {
        return deviceTypeService.getTypeList();
    }

    @ApiOperation("添加维护记录")
    @PostMapping("/maintenance/admin/add")
    public Response<Boolean> addMaintenance(@Validated @RequestBody AddDeviceMaintenanceRequest addDeviceMaintenanceRequest) {
        return deviceMaintenanceService.addMaintenance(addDeviceMaintenanceRequest);
    }

    @ApiOperation("删除维护记录")
    @DeleteMapping("/maintenance/admin/remove/{id}")
    public Response<Boolean> removeMaintenance(@PathVariable Long id) {
        return deviceMaintenanceService.removeMaintenance(id);
    }

    @ApiOperation("更新维护记录")
    @PutMapping("/maintenance/admin/update")
    public Response<Boolean> updateMaintenance(@Validated @RequestBody UpdateDeviceMaintenanceRequest updateDeviceMaintenanceRequest) {
        return deviceMaintenanceService.updateMaintenance(updateDeviceMaintenanceRequest);
    }

    @ApiOperation("获取维护列表")
    @GetMapping("/maintenance/admin/list")
    public Response<List<DeviceMaintenanceVO>> getMaintenanceList() {
        return deviceMaintenanceService.getMaintenanceList();
    }

    @ApiOperation("添加设备")
    @PostMapping("/admin/add")
    public Response<Boolean> addDevice(@Validated @RequestBody AddDeviceRequest addDeviceRequest) {
        return deviceService.addDevice(addDeviceRequest);
    }

    @ApiOperation("删除设备")
    @DeleteMapping("/admin/remove/{id}")
    public Response<Boolean> removeDevice(@PathVariable Long id) {
        return deviceService.removeDevice(id);
    }

    @ApiOperation("更新设备")
    @PutMapping("/admin/update")
    public Response<Boolean> updateDevice(@Validated @RequestBody UpdateDeviceRequest updateDeviceRequest) {
        return deviceService.updateDevice(updateDeviceRequest);
    }

    @ApiOperation("获取设备列表")
    @GetMapping("/list")
    public Response<List<DeviceInfoVO>> getDeviceList() {
        return deviceService.getDeviceList();
    }

    @ApiOperation("添加预约")
    @PostMapping("/order/add")
    public Response<Boolean> addOrder(@Validated @RequestBody AddDeviceOrderRequest addDeviceOrderRequest) {
        return deviceOrderService.addOrder(addDeviceOrderRequest);
    }

    @ApiOperation("撤销预约")
    @DeleteMapping("/order/remove/{id}")
    public Response<Boolean> removeOrder(@PathVariable Long id) {
        return deviceOrderService.removeOrder(id);
    }

    @ApiOperation("修改预约信息(管理员)")
    @PutMapping("/order/admin/update")
    public Response<Boolean> updateOrder(@Validated @RequestBody UpdateDeviceOrderRequest updateDeviceOrderRequest) {
        return deviceOrderService.updateOrder(updateDeviceOrderRequest);
    }

    @ApiOperation("修改预约信息(用户)")
    @PutMapping("/order/update")
    public Response<Boolean> updateOrderByUser(@Validated @RequestBody UpdateDeviceOrderByUserRequest updateDeviceOrderByUserRequest) {
        return deviceOrderService.updateOrderByUser(updateDeviceOrderByUserRequest);
    }

    @ApiOperation("获取预约列表")
    @GetMapping("/order/list")
    public Response<List<DeviceOrderVO>> getOrderList() {
        return deviceOrderService.getOrderList();
    }

    @ApiOperation("获取当前登录用户预约")
    @GetMapping("/myOrders")
    public Response<List<DeviceOrderVO>> myOrders() {
        return deviceOrderService.myOrders();
    }

    @ApiOperation("根据设备id获取设备预约记录")
    @GetMapping("/device/{id}")
    public Response<List<DeviceOrderVO>> getDeviceOrderListById(@PathVariable Long id) {
        return deviceOrderService.getDeviceOrderListById(id);
    }

}
