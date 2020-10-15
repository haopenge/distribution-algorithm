package com.husky.prototype;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Date;

/**
 * @author liuph
 * @desc 齐天大圣   --》 克隆接口的实现类
 * @date 2020/10/15 18:02
 */
public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @SneakyThrows
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    /**
     * @return 深克隆
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deepClone() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);


        ByteArrayInputStream bai = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bai);

        QiTianDaSheng qiTianDaSheng = (QiTianDaSheng) ois.readObject();
        qiTianDaSheng.birthday = new Date();
        return qiTianDaSheng;

    }

    /**
     * @desc 淺克隆
     * @author liuph
     * @date  2020/10/15 19:14
     */
    public QiTianDaSheng shallowClone(QiTianDaSheng target) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.height;
        qiTianDaSheng.jinGuBang = target.jinGuBang;
        qiTianDaSheng.birthday = new Date();
        return qiTianDaSheng;
    }

}
