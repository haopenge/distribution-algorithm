package com.uu.husky;

import com.sun.tools.javac.util.ServiceLoader;
import com.uu.husky.service.IAnimalService;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/11 14:21
 **/
public class Boot {
    public static void main(String[] args) {
        ServiceLoader<IAnimalService> loads = ServiceLoader.load(IAnimalService.class);
        for (IAnimalService load : loads) {
            load.call();
        }
    }
}
