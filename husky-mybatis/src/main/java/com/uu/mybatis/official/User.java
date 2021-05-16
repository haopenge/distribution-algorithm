package com.uu.mybatis.official;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String phone;

    private String remark;

    private Date createTime;

    private Date updateTime;
}