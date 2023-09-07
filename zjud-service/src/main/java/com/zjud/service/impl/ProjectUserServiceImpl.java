package com.zjud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.model.entity.ProjectUser;
import com.zjud.service.ProjectUserService;
import com.zjud.mapper.ProjectUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86178
* @description 针对表【project_user(项目用户联系表)】的数据库操作Service实现
* @createDate 2023-09-05 14:22:40
*/
@Service
public class ProjectUserServiceImpl extends ServiceImpl<ProjectUserMapper, ProjectUser>
    implements ProjectUserService{

}




