package com.zjud.controller;

import com.zjud.model.dto.lab.AddLabRequest;
import com.zjud.model.dto.lab.UpdateLabRequest;
import com.zjud.model.entity.Lab;
import com.zjud.response.Response;
import com.zjud.service.LabService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/31 14:34
 * @description 实验室controller
 */
@RestController
@Api(tags = "实验室接口")
@RequestMapping("lab")
public class LabController {

    @Resource
    private LabService labService;

    // 管理员

    @DeleteMapping("/admin/remove/{id}")
    @ApiOperation("删除单个实验室")
    public Response<Boolean> removeLabById(@PathVariable Long id) {
        return labService.removeLabById(id);
    }

    @DeleteMapping("/admin/removeBatch")
    @ApiOperation("批量删除实验室")
    public Response<Boolean> removeLabBatch(@RequestBody List<Long> ids) {
        return labService.removeLabBatch(ids);
    }

    @GetMapping("/list")
    @ApiOperation("获取实验室列表")
    public Response<List<Lab>> getLabList() {
        return labService.getLabList();
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("获取单个实验室")
    public Response<Lab> getLabById(@PathVariable Long id) {
        return labService.getLabById(id);
    }

    @PutMapping("/admin/update")
    @ApiOperation("更新实验室信息")
    public Response<Boolean> updateLab(@RequestBody UpdateLabRequest updateLabRequest) {
        return labService.updateLab(updateLabRequest);
    }

    @PostMapping("/admin/add")
    @ApiOperation("添加单个实验室")
    public Response<Boolean> addLab(@RequestBody AddLabRequest addLabRequest) {
        return labService.addLab(addLabRequest);
    }


}
