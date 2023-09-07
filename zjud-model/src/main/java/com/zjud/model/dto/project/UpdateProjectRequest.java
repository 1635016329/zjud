package com.zjud.model.dto.project;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 9:55
 * @description
 */
@Data
public class UpdateProjectRequest {

    @NotNull(message = "项目id不能为空")
    private Long projectId;

    @NotBlank(message = "项目名不能为空")
    private String projectName;

    @NotNull(message = "项目分类不能为空")
    private Long projectTypeId;

    @NotBlank(message = "项目目的不能为空")
    private String target;
}
