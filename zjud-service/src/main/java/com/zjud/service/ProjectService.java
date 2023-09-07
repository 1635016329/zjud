package com.zjud.service;

import com.zjud.model.dto.project.*;
import com.zjud.model.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.model.vo.ProjectApplicationVO;
import com.zjud.model.vo.ProjectMemberVO;
import com.zjud.model.vo.ProjectVO;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【project(项目管理表)】的数据库操作Service
* @createDate 2023-09-05 14:22:40
*/
public interface ProjectService extends IService<Project> {

    /**
     * 添加项目
     * @param addProjectRequest
     * @return
     */
    Response<Boolean> addProject(AddProjectRequest addProjectRequest);

    /**
     * 根据项目id获取项目信息
     * @param id
     * @return
     */
    Response<ProjectVO> getProjectById(Long id);

    /**
     * 获取项目列表
     * @return
     */
    Response<List<ProjectVO>> getProjectList();

    /**
     * 根据项目id删除项目
     * @param id
     * @return
     */
    Response<Boolean> removeProjectById(Long id);

    /**
     * 修改项目基本信息
     * @param updateProjectRequest
     * @return
     */
    Response<Boolean> updateProject(UpdateProjectRequest updateProjectRequest);

    /**
     * 添加项目成员
     * @param addProjectUserRequest
     * @return
     */
    Response<Boolean> addProjectUser(AddProjectUserRequest addProjectUserRequest);

    /**
     * 删除项目成员
     * @param deleteMemberRequest
     * @return
     */
    Response<Boolean> removeMember(DeleteMemberRequest deleteMemberRequest);

    /**
     * 根据项目id获取项目成员列表
     * @param id
     * @return
     */
    Response<List<ProjectMemberVO>> getMemberListById(Long id);

    /**
     * 申请加入项目
     * @param
     * @return
     */
    Response<Boolean> joinProject(JoinProjectRequest joinProjectRequest);

    /**
     * 退出项目
     * @param id 项目id
     * @return
     */
    Response<Boolean> quitProject(Long id);

    /**
     * 查看我参加的所有项目列表
     * @return
     */
    Response<List<ProjectVO>> getMyProjectList();

    /**
     * 获取成员申请列表
     * @return
     */
    Response<List<ProjectApplicationVO>> getMemberApplicationList(Long id);

    /**
     * 成员申请审核
     * @return
     */
    Response<Boolean> auditApplication(AuditApplicationRequest auditApplicationRequest);
}
