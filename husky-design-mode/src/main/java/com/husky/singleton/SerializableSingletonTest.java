package com.husky.singleton;

import java.io.*;

/**
 * @author liuph
 * @desc 序列化 破坏单例模式
 * @date 2020/10/14 11:58
 */
public class SerializableSingletonTest {

    public static void main(String[] args) {
        SerializableSingleton s1 = null;

        SerializableSingleton s2 = SerializableSingleton.getInstance();


        // 将s2 对象序列化到本地
        try (FileOutputStream fos = new FileOutputStream("SerializableSingleton.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 将本地序列化文件，转化为对象
        try (FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            s1 = (SerializableSingleton) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);


    }

}


