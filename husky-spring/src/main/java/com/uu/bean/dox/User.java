package com.uu.bean.dox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 用户
 * @author liuph
 * @date 2021/02/25 16:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private Integer phone;

    private String remark;
}
