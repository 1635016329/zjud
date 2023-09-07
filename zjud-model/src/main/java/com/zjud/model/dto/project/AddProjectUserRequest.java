package com.zjud.model.dto.project;

import lombok.Data;

import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 10:17
 * @description
 */
@Data
public class AddProjectUserRequest {

    private Long projectId;

    private List<String> usernames;
}
