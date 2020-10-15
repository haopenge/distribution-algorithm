package com.husky.prototype;

/**
 * @author liuph
 * @desc 深克隆 测试
 * @date 2020/10/15 18:34
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        try {
            QiTianDaSheng deepCloneObj = (QiTianDaSheng) qiTianDaSheng.clone();
            System.out.println("深克隆：" + (qiTianDaSheng.jinGuBang == deepCloneObj.jinGuBang));
        } catch (Exception e) {
            e.printStackTrace();
        }


        QiTianDaSheng shallowObj = qiTianDaSheng.shallowClone(qiTianDaSheng);
        System.out.println("浅克隆： " + (qiTianDaSheng.jinGuBang == shallowObj.jinGuBang));

    }
}
