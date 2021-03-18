package com.uu.husky.spi.jdk.service.impl;

import com.uu.husky.spi.jdk.service.IAnimalService;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/11 14:19
 **/
public class DogService implements IAnimalService {
    public void call() {
        System.out.println("小狗狗 汪汪汪");
    }
}
