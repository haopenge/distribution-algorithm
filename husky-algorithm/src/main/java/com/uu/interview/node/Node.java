package com.uu.interview.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author liuph
 * @desc
 * @date 2021/04/15 14:44
 */
@Setter
@Getter
@NoArgsConstructor
public class Node {
    private Node next;
    private Integer number;

    Node(Integer number) {
        this.number = number;
        next = null;
    }


}

