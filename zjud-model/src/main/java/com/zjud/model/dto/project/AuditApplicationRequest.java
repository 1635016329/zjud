package com.zjud.model.dto.project;

import lombok.Data;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/6 14:34
 * @description
 */
@Data
public class AuditApplicationRequest {

    private Long applicationId;

    private Integer auditResult;
}
