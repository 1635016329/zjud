package com.zjud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.model.entity.ProjectType;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.ProjectTypeService;
import com.zjud.mapper.ProjectTypeMapper;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86178
* @description 针对表【project_type(项目分类表)】的数据库操作Service实现
* @createDate 2023-09-05 14:22:40
*/
@Service
public class ProjectTypeServiceImpl extends ServiceImpl<ProjectTypeMapper, ProjectType>
    implements ProjectTypeService{

    @Override
    public Response<List<ProjectType>> getTypeList() {
        List<ProjectType> list = list();
        return ResultUtils.success(list);
    }

    @Override
    public Response<Boolean> addType(String typename) {
        ProjectType projectType = new ProjectType();
        projectType.setTypeName(typename);
        boolean save = save(projectType);
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
    public Response<Boolean> updateType(ProjectType projectType) {
        boolean update = updateById(projectType);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }
}




