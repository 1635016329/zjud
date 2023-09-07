package com.zjud.model.dto.project;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 9:33
 * @description 添加项目请求
 */
@Data
public class AddProjectRequest {

    @NotBlank(message = "项目名不能为空")
    private String projectName;

    @NotNull(message = "项目分类不能为空")
    private Long projectTypeId;

    @NotBlank(message = "项目目的不能为空")
    private String target;
}
