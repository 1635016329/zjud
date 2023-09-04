package com.zjud.model.dto.lab;

import lombok.Data;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/31 14:49
 * @description
 */
@Data
public class AddLabRequest {

    /**
     * 实验室名称
     */
    private String labName;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 实验室布局
     */
    private String layout;
}
