package com.uu.mybatis.official.domain;

import lombok.Data;

import java.util.Date;

/**
 * @desc 审计model
 * @author liuph
 * @date 2021/05/16 14:04
 */
@Data
public class ModifyModel {
    private String mId = "mid";
    private String mName = "mname";
    private String mTime = "mtime";
    private String cId = "cid";
    private String cName = "cname";
    private String cTime = "ctime";
    private String id = "id";
    private Object employeeId;
    private Object employeeName;
    private Date opTime;
    private Integer positionLevel;
    private Integer departmentId;
    private String modifierId = "modifierId";
    private String modifierName = "modifierName";
    private String updateTime = "updateTime";
    private String creatorId = "creatorId";
    private String creatorName = "creatorName";
    private String createTime = "createTime";
    public ModifyModel() {
    }

    public ModifyModel(Integer employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public ModifyModel(Integer employeeId, String employeeName, Date opTime) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.opTime = opTime;
    }

    public ModifyModel(String employeeName) {
        this.employeeId = 0;
        this.employeeName = employeeName;
    }
}
