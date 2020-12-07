package com.husky.demo.tomcat.hanlder;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @desc  请求封装
 * @author liuph
 * @date 2020/12/07 17:34
 */
@Setter
@Getter
public class PhRequest {

    private String method;

    private String uri;



    public PhRequest(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        while ((line = br.readLine()) != null){
             System.out.println(line);

            String headLineStr = line.split("\n")[0];
            String[] headLineArray = headLineStr.split("\\s");

            method = headLineArray[0];
            uri = headLineArray[1];

            break;

        }

    }
}
