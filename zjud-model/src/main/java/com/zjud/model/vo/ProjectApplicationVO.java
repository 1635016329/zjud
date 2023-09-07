package com.zjud.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 14:19
 * @description
 */
@Data
public class ProjectApplicationVO {
    /**
     * 申请id
     */
    private Long applicationId;

    /**
     * 申请项目id
     */
    private ProjectVO projectVO;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 申请状态
     */
    private Integer applicationStatus;

    /**
     * 申请者
     */
    private String applicant;

}
