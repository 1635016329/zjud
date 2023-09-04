package com.zjud.service;

import com.zjud.model.dto.lab.AddLabRequest;
import com.zjud.model.dto.lab.UpdateLabRequest;
import com.zjud.model.entity.Lab;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【lab(实验室表)】的数据库操作Service
* @createDate 2023-08-31 14:30:33
*/
public interface LabService extends IService<Lab> {

    /**
     * 删除单个实验室
     * @param id
     * @return
     */
    Response<Boolean> removeLabById(Long id);

    /**
     * 批量删除实验室
     * @param ids
     * @return
     */
    Response<Boolean> removeLabBatch(List<Long> ids);

    /**
     * 获取实验室列表
     * @return
     */
    Response<List<Lab>> getLabList();

    /**
     * 获取单个实验室
     * @param id
     * @return
     */
    Response<Lab> getLabById(Long id);

    /**
     * 更新实验室信息
     * @param updateLabRequest
     * @return
     */
    Response<Boolean> updateLab(UpdateLabRequest updateLabRequest);

    /**
     * 添加实验室
     * @param addLabRequest
     * @return
     */
    Response<Boolean> addLab(AddLabRequest addLabRequest);

}
