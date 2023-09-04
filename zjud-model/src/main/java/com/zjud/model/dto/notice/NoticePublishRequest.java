package com.zjud.model.dto.notice;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/30 16:16
 * @description 发布公告请求
 */
@Data
public class NoticePublishRequest {
    /**
     * 公告标题
     */
    @NotBlank
    private String title;

    /**
     * 公告内容
     */
    @NotBlank
    private String content;
}
