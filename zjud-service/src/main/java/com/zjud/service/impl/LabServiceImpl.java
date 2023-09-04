package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.model.dto.lab.AddLabRequest;
import com.zjud.model.dto.lab.UpdateLabRequest;
import com.zjud.model.entity.Lab;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.LabService;
import com.zjud.mapper.LabMapper;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86178
* @description 针对表【lab(实验室表)】的数据库操作Service实现
* @createDate 2023-08-31 14:30:33
*/
@Service
public class LabServiceImpl extends ServiceImpl<LabMapper, Lab>
    implements LabService{

    @Override
    public Response<Boolean> removeLabById(Long id) {
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> removeLabBatch(List<Long> ids) {
        boolean remove = removeBatchByIds(ids);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<Lab>> getLabList() {
        List<Lab> list = list();
        return ResultUtils.success(list);
    }

    @Override
    public Response<Lab> getLabById(Long id) {
        Lab lab = getById(id);
        ThrowUtils.throwIf(lab == null, new BusinessException(ResponseCode.NOT_FOUND_ERROR));
        return ResultUtils.success(lab);
    }

    @Override
    public Response<Boolean> updateLab(UpdateLabRequest updateLabRequest) {
        Lab lab = BeanUtil.copyProperties(updateLabRequest, Lab.class);
        boolean update = updateById(lab);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> addLab(AddLabRequest addLabRequest) {
        Lab lab = BeanUtil.copyProperties(addLabRequest, Lab.class);
        boolean save = save(lab);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }
}




