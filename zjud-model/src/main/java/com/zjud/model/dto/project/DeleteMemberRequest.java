package com.zjud.model.dto.project;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 10:07
 * @description
 */
@Data
public class DeleteMemberRequest {

    @NotNull(message = "项目id不能为空")
    private Long projectId;

    @NotNull(message = "用户id不能为空")
    private Long userId;
}
