package com.uu.interview20210331;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @desc
 * @author liuph
 * @date 2021/03/31 21:19
 */
public class QuChong {

    // 前提： list 有序去重
    // 思路1： 遍历list ,将值存入 LikeHashMap, key=值， value=数量
    // 思路2： java8 stream流 distinct(),

    public static String[] getTarget(String [] sourceArray){
        List<String> list = Arrays.stream(sourceArray).distinct().collect(Collectors.toList());

        String [] targetArray = new String[list.size()];

        return list.toArray(targetArray);
    }

    public static String[] getTargetV2(String [] sourceArray){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for (String s : sourceArray) {
            map.merge(s, 1, Integer::sum);
        }

        Set<String> keySet = map.keySet();
        String [] targetArray = new String[keySet.size()];
        keySet.toArray(targetArray);

        return targetArray;
    }
    
    public static void main(String[] args) {
        String [] sourceArray = {"B","A","C","D","A","B"};

        String[] target = getTarget(sourceArray);
        Arrays.stream(target).forEach(System.out::println);

        System.out.println("........");

        String[] targetV2 = getTargetV2(sourceArray);
        Arrays.stream(targetV2).forEach(System.out::println);
    }
}
