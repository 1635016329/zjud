package com.zjud.model.vo;

import com.zjud.model.entity.ProjectType;
import lombok.Data;

import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 9:41
 * @description
 */
@Data
public class ProjectVO {
    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 项目分类
     */
    private ProjectType projectType;

    /**
     * 项目目的
     */
    private String target;

    /**
     * 创建时间
     */
    private Date createTime;

}
