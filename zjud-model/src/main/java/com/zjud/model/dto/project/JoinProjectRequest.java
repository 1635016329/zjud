package com.zjud.model.dto.project;

import lombok.Data;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 14:54
 * @description
 */
@Data
public class JoinProjectRequest {

    /**
     * 申请项目id
     */
    private Long projectId;


    /**
     * 申请者
     */
    private String applicant;

}
