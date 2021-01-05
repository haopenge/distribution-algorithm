package com.uu.sort;

import java.util.Arrays;

/**
 * 描述：常见排序
 * User Liu PengHao
 * Date 2019/02/22 15:05
 **/
public class Sort {


    /**
     * 假设第一个元素是对的
     * @param sourceArray
     */
    public static int[] insertSort(int [] sourceArray){
        int [] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        for (int i = 0; i < arr.length; i++) {

            // 记录要插入的数据
            int temp = arr[i];

            int j = i ;
            // 大于0 ，且 小于 当前值，继续向左遍历
            while(j > 0 && arr[j - 1] > temp){
                arr[j] = arr[j-1];
                j--;
            }

            // 存在比其小的值
            if(j != i){
                arr[j] = temp;
            }
        }
        return arr;
    }



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
