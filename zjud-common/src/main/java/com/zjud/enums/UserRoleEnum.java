package com.zjud.enums;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/30 10:44
 * @description
 */
public enum UserRoleEnum {
    DEFAULT_USER(0, "默认"),
    ROOT(1, "root"),
    PROJECT_GROUP_LEADER(2, "项目组长")
    ;

    private Integer key;
    private String value;

    UserRoleEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
