package com.husky.proxy.jdk;

import com.husky.proxy.Girl;
import com.husky.proxy.Person;

/**
 * @desc jdk 测试类
 * @author liuph
 * @date 2020/10/19 12:51
 */
public class JdkTest {
    public static void main(String[] args) {
        Girl girl = new Girl();
        Person person = JDKMeiPo.getProxyPerson(girl);
        person.findLove();
    }
}
