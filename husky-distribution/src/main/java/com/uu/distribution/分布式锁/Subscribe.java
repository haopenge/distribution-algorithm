package com.uu.distribution.分布式锁;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/30 17:01
 **/
@NoArgsConstructor
@Data
@Document(collection = "subscribe")
public class Subscribe {
    /**
     * studentId : stu01
     * schoolId : china
     * coachId : lili
     * subjectId : 1
     * start : 2019-02-02 09:00
     * end : 2019-02-02 10:00
     */
    @Id
    private String id;

    private String studentId;
    private String schoolId;
    private String coachId;
    private String subjectId;
    private String start;
    private String end;
}
