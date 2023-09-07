package com.zjud.service;

import com.zjud.model.entity.ProjectType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【project_type(项目分类表)】的数据库操作Service
* @createDate 2023-09-05 14:22:40
*/
public interface ProjectTypeService extends IService<ProjectType> {

    Response<List<ProjectType>> getTypeList();

    Response<Boolean> addType(String typename);

    Response<Boolean> removeType(Long id);

    Response<Boolean> updateType(ProjectType projectType);
}
