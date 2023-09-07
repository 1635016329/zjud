package com.zjud.controller;

import com.zjud.model.dto.project.*;
import com.zjud.model.entity.ProjectType;
import com.zjud.model.vo.ProjectApplicationVO;
import com.zjud.model.vo.ProjectMemberVO;
import com.zjud.model.vo.ProjectVO;
import com.zjud.response.Response;
import com.zjud.service.ProjectService;
import com.zjud.service.ProjectTypeService;
import com.zjud.service.ProjectUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/5 14:20
 * @description 项目接口
 */
@RestController
@RequestMapping("/project")
@Api(tags = {"项目接口"})
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @Resource
    private ProjectTypeService projectTypeService;

    @GetMapping("/{id}")
    @ApiOperation("根据id获取项目信息")
    public Response<ProjectVO> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/list")
    @ApiOperation("获取项目列表")
    public Response<List<ProjectVO>> getProjectList() {
        return projectService.getProjectList();
    }

    @DeleteMapping("/admin/remove/{id}")
    @ApiOperation("根据id删除项目")
    public Response<Boolean> removeProjectById(@PathVariable Long id) {
        return projectService.removeProjectById(id);
    }

    @PutMapping("/admin/admin/update")
    @ApiOperation("修改项目信息")
    public Response<Boolean> updateProject(@RequestBody UpdateProjectRequest updateProjectRequest) {
        return projectService.updateProject(updateProjectRequest);
    }

    @PostMapping("/admin/add")
    @ApiOperation("添加项目")
    public Response<Boolean> addProject(@RequestBody AddProjectRequest addProjectRequest) {
        return projectService.addProject(addProjectRequest);
    }

    @PostMapping("/admin/addProjectUser")
    @ApiOperation("添加项目成员")
    public Response<Boolean> addProjectUser(@RequestBody AddProjectUserRequest addProjectUserRequest) {
        return projectService.addProjectUser(addProjectUserRequest);
    }

    @DeleteMapping("/admin/member/remove")
    @ApiOperation("删除项目成员")
    public Response<Boolean> removeMemberById(@RequestBody DeleteMemberRequest deleteMemberRequest) {
        return projectService.removeMember(deleteMemberRequest);
    }

    @GetMapping("/admin/members/")
    @ApiOperation("根据项目id获取项目成员列表")
    public Response<List<ProjectMemberVO>> getMemberListById(Long id) {
        return projectService.getMemberListById(id);
    }

    @GetMapping("/admin/application/list/{id}")
    @ApiOperation("获取成员申请列表")
    public Response<List<ProjectApplicationVO>> getMemberApplicationList(@PathVariable Long id) {
        return projectService.getMemberApplicationList(id);
    }

    @PostMapping("/application/audit")
    @ApiOperation("成员申请审核")
    public Response<Boolean> auditApplication(@RequestBody AuditApplicationRequest auditApplicationRequest) {
        return projectService.auditApplication(auditApplicationRequest);
    }

    //成员
    @PostMapping("/member/join")
    @ApiOperation("申请加入项目")
    public Response<Boolean> joinProject(@RequestBody JoinProjectRequest joinProjectRequest) {
        return projectService.joinProject(joinProjectRequest);
    }

    @PostMapping("/quitProject/{id}")
    @ApiOperation("退出项目")
    public Response<Boolean> quitProject(@PathVariable Long id) {
        return projectService.quitProject(id);
    }

    @GetMapping("/my/list")
    @ApiOperation("查看我参加的所有项目列表")
    public Response<List<ProjectVO>> getMyProjectList() {
        return projectService.getMyProjectList();
    }

    @GetMapping("types")
    @ApiOperation("查看所有项目分类")
    public Response<List<ProjectType>> getTypeList() {
        return projectTypeService.getTypeList();
    }

    @GetMapping("/admin/types/add")
    @ApiOperation("添加项目分类")
    public Response<Boolean> addType(String typename) {
        return projectTypeService.addType(typename);
    }

    @GetMapping("/admin/types/remove/{id}")
    @ApiOperation("删除项目分类")
    public Response<Boolean> removeType(@PathVariable Long id) {
        return projectTypeService.removeType(id);
    }

    @GetMapping("/admin/types/update")
    @ApiOperation("修改项目分类")
    public Response<Boolean> updateType(@RequestBody ProjectType projectType) {
        return projectTypeService.updateType(projectType);
    }


}
