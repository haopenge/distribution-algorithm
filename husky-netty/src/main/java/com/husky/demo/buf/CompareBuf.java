package com.husky.demo.buf;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

/**
 * @desc  传统拷贝与  netty 0拷贝 速度对比
 * @author liuph
 * @date 2021/01/19 15:15
 */
public class CompareBuf {

    @Test
    public void test() throws IOException {
        String sourceFilePath = "e:/data/data.zip";
        String targetFilePath1 = "e:/data/data_copy1.zip";
        String targetFilePath2 = "e:/data/data_copy2.zip";

       // nettyCopy(sourceFilePath,targetFilePath2);
        traditionCopy(sourceFilePath,targetFilePath1);
    }

    public void traditionCopy(String sourceFilePath ,String targetFilePath){
        long timestamp = System.currentTimeMillis();
        // 文件对应的 FileChannel
        try(FileInputStream fis = new FileInputStream(sourceFilePath);
            FileOutputStream fos = new FileOutputStream(targetFilePath);
        ){
            IOUtils.copy(fis,fos);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(String.format(" [traditionCopy] timout : %s",System.currentTimeMillis() - timestamp));
    }

    public void nettyCopy(String sourceFilePath ,String targetFilePath) {
        long timestamp = System.currentTimeMillis();

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(sourceFilePath, "rw");
            WritableByteChannel writableByteChannel = Channels.newChannel(new FileOutputStream(targetFilePath));){

            FileRegion fileRegion = new DefaultFileRegion(randomAccessFile.getChannel(), 0, randomAccessFile.length());
            fileRegion.transferTo(writableByteChannel,0);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(String.format(" [nettyCopy] timout : %s",System.currentTimeMillis() - timestamp));
    }

}
