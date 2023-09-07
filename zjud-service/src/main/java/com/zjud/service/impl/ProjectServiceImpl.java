package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.mapper.ProjectMapper;
import com.zjud.model.dto.project.*;
import com.zjud.model.entity.*;
import com.zjud.model.vo.ProjectApplicationVO;
import com.zjud.model.vo.ProjectMemberVO;
import com.zjud.model.vo.ProjectVO;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.*;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import com.zjud.util.TokenThreadLocal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 86178
 * @description 针对表【project(项目管理表)】的数据库操作Service实现
 * @createDate 2023-09-05 14:22:40
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project>
        implements ProjectService {

    @Resource
    private ProjectTypeService projectTypeService;

    @Resource
    private UserService userService;

    @Resource
    private ProjectUserService projectUserService;

    @Resource
    private ProjectUserApplicationService projectUserApplicationService;

    @Override
    public Response<Boolean> addProject(AddProjectRequest addProjectRequest) {
        Project project = BeanUtil.copyProperties(addProjectRequest, Project.class);
        boolean save = save(project);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<ProjectVO> getProjectById(Long id) {
        Project project = getById(id);
        ThrowUtils.throwIf(project == null, new BusinessException(ResponseCode.NOT_FOUND_ERROR));
        ProjectVO projectVO = BeanUtil.copyProperties(project, ProjectVO.class);
        ProjectType type = projectTypeService.getById(project.getProjectTypeId());
        projectVO.setProjectType(type);
        return ResultUtils.success(projectVO);
    }

    @Override
    public Response<List<ProjectVO>> getProjectList() {
        List<Project> list = list();
        List<ProjectVO> projectVOList = new ArrayList<>();
        for (Project project : list) {
            ProjectVO projectVO = BeanUtil.copyProperties(project, ProjectVO.class);
            ProjectType type = projectTypeService.getById(project.getProjectTypeId());
            projectVO.setProjectType(type);
            projectVOList.add(projectVO);
        }
        return ResultUtils.success(projectVOList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Boolean> removeProjectById(Long id) {
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        QueryWrapper<ProjectUser> projectUserQueryWrapper = new QueryWrapper<>();
        projectUserQueryWrapper.eq("project_id", id);
        boolean remove1 = projectUserService.remove(projectUserQueryWrapper);
        ThrowUtils.throwIf(!remove1, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> updateProject(UpdateProjectRequest updateProjectRequest) {
        Project project = BeanUtil.copyProperties(updateProjectRequest, Project.class);
        boolean update = updateById(project);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> addProjectUser(AddProjectUserRequest addProjectUserRequest) {
        Long projectId = addProjectUserRequest.getProjectId();
        List<String> usernames = addProjectUserRequest.getUsernames();

        for (String username : usernames) {
            User user = userService.query().eq("username", username).one();
            ProjectUser projectUser = new ProjectUser();
            projectUser.setProjectId(projectId);
            projectUser.setUserId(user.getUserId());
            projectUserService.save(projectUser);
        }
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> removeMember(DeleteMemberRequest deleteMemberRequest) {
        Long projectId = deleteMemberRequest.getProjectId();
        Long userId = deleteMemberRequest.getUserId();

        QueryWrapper<ProjectUser> projectUserQueryWrapper = new QueryWrapper<>();
        projectUserQueryWrapper.eq("user_id", userId).eq("project_id", projectId);
        boolean remove = projectUserService.remove(projectUserQueryWrapper);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<ProjectMemberVO>> getMemberListById(Long id) {
        QueryWrapper<ProjectUser> projectUserQueryWrapper = new QueryWrapper<>();
        projectUserQueryWrapper.eq("project_id", id);
        List<ProjectUser> projectUsers = projectUserService.list(projectUserQueryWrapper);
        List<ProjectMemberVO> list = new ArrayList<>();
        for (ProjectUser item : projectUsers) {
            User user = userService.getById(item.getUserId());
            ProjectMemberVO projectMemberVO = new ProjectMemberVO();
            projectMemberVO.setUsername(user.getUsername());
            projectMemberVO.setUseRole(user.getUserRole());
            list.add(projectMemberVO);
        }
        return ResultUtils.success(list);
    }

    @Override
    public Response<Boolean> joinProject(JoinProjectRequest joinProjectRequest) {
        Long projectId = joinProjectRequest.getProjectId();
        String applicant = joinProjectRequest.getApplicant();
        ProjectUserApplication projectUserApplication = new ProjectUserApplication();
        projectUserApplication.setProjectId(projectId);
        projectUserApplication.setApplicant(applicant);
        boolean save = projectUserApplicationService.save(projectUserApplication);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> quitProject(Long id) {
        Long userId = Convert.toLong(JWTUtil.parseToken(TokenThreadLocal.getToken()).getPayload("userId"));
        QueryWrapper<ProjectUser> projectUserQueryWrapper = new QueryWrapper<>();
        projectUserQueryWrapper.eq("project_id", id).eq("user_id", userId);
        boolean remove = projectUserService.remove(projectUserQueryWrapper);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(true);
    }

    @Override
    public Response<List<ProjectVO>> getMyProjectList() {
        Long userId = Convert.toLong(JWTUtil.parseToken(TokenThreadLocal.getToken()).getPayload("userId"));
        List<ProjectVO> list = new ArrayList<>();
        List<ProjectUser> projectUserList = projectUserService.query().eq("user_id", userId).list();
        for (ProjectUser item : projectUserList) {
            Long projectId = item.getProjectId();
            Response<ProjectVO> projectById = getProjectById(projectId);
            list.add(projectById.getData());
        }
        return ResultUtils.success(list);
    }

    @Override
    public Response<List<ProjectApplicationVO>> getMemberApplicationList(Long id) {
        QueryWrapper<ProjectUserApplication> projectUserApplicationQueryWrapper = new QueryWrapper<>();
        projectUserApplicationQueryWrapper.eq("project_id", id);
        List<ProjectUserApplication> list = projectUserApplicationService.list(projectUserApplicationQueryWrapper);
        List<ProjectApplicationVO> applicationVOList = new ArrayList<>();
        for (ProjectUserApplication item : list) {
            Long projectId = item.getProjectId();
            ProjectApplicationVO projectApplicationVO = BeanUtil.copyProperties(item, ProjectApplicationVO.class);
            Response<ProjectVO> project = getProjectById(projectId);
            projectApplicationVO.setProjectVO(project.getData());
            applicationVOList.add(projectApplicationVO);
        }
        return ResultUtils.success(applicationVOList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Boolean> auditApplication(AuditApplicationRequest auditApplicationRequest) {
        Long applicationId = auditApplicationRequest.getApplicationId();
        Integer auditResult = auditApplicationRequest.getAuditResult();

        UpdateWrapper<ProjectUserApplication> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("application_status", auditResult)
                .eq("application_id", applicationId);
        boolean update = projectUserApplicationService.update(updateWrapper);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.FAIL));
        if (auditResult == 1) {
            ProjectUserApplication application = projectUserApplicationService.getById(applicationId);
            ProjectUser projectUser = new ProjectUser();
            projectUser.setProjectId(application.getProjectId());
            User user = userService.query().eq("username", application.getApplicant()).one();
            projectUser.setUserId(user.getUserId());
            boolean save = projectUserService.save(projectUser);
            ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.FAIL));
        }
        return ResultUtils.success(true);
    }
}




