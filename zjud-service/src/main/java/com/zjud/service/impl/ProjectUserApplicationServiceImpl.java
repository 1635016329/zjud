package com.zjud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.model.entity.ProjectUserApplication;
import com.zjud.service.ProjectUserApplicationService;
import com.zjud.mapper.ProjectUserApplicationMapper;
import org.springframework.stereotype.Service;

/**
* @author 86178
* @description 针对表【project_user_application(项目成员申请表)】的数据库操作Service实现
* @createDate 2023-09-06 15:24:02
*/
@Service
public class ProjectUserApplicationServiceImpl extends ServiceImpl<ProjectUserApplicationMapper, ProjectUserApplication>
    implements ProjectUserApplicationService{

}




