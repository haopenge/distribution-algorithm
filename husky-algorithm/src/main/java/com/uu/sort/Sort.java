package com.uu.sort;

import java.util.Arrays;

/**
 * 描述：常见排序
 * User Liu PengHao
 * Date 2019/02/22 15:05
 **/
public class Sort {

    /**
     * 冒泡排序
     *
     * @param sourceArray 源
     * @return 排序好的数组
     */
    public static int[] bubblingSort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = i; j < sourceArray.length; j++) {
                if (sourceArray[i] > sourceArray[j]) {
                    // 大于左边的交换
                    int temp = sourceArray[i];
                    sourceArray[i] = sourceArray[j];
                    sourceArray[j] = temp;
                }
            }
        }
        return sourceArray;
    }

    /**
     * 选择排序:可以看做是在冒泡的基础上的改进，冒泡是比当前的小就交换，选择是只记录一个索引
     *
     * @param sourceArray 源
     * @return 排序好的数组
     */
    public static int[] selectSort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {

            int min = i;
            // 比较记录最小的索引
            for (int j = i; j < sourceArray.length; j++) {
                if (sourceArray[min] > sourceArray[j]) {
                    min = j;
                }
            }

            if (min - i != 0) {
                // 不等于0 ，就交换呗
                int temp = sourceArray[min];
                sourceArray[min] = sourceArray[i];
                sourceArray[i] = temp;
            }

        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] sourceArray = {2, 3, 6, 4, 5, 7, 1};
        Arrays.stream(sourceArray).forEach(entity -> System.out.print(entity + "，"));

        System.out.println("\r\n" + ".........无敌的分割线..........");

        // sourceArray = bubblingSort(sourceArray);
        sourceArray = selectSort(sourceArray);

        Arrays.stream(sourceArray).forEach(entity -> System.out.print(entity + "，"));
    }
}
