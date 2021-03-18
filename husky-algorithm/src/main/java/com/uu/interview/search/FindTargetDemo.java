package com.uu.interview.search;

/**
 * @author liuph
 * @desc 查找算法
 * @date 2021/03/02 16:20
 */
public class FindTargetDemo {

    public static void main(String[] args) {
        int[] sourceArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(twoSearch(sourceArray, 3));
    }


    /**
     * @desc 二分法查找数据
     * @author liuph
     * @date 2021/03/02 16:21
     * @return 目标值 的 索引
     */
    public static int twoSearch(int[] sourceArray, int value) {
        int start = 0;
        int end = sourceArray.length;

        while (start < end) {
            int middle = (start + end) / 2;
            if (sourceArray[middle] == value) {
                return middle;
            }
            if (sourceArray[middle] > value) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return -1;
    }


    public static  int twoSearch2(int[] sourceArray,int value){
        //
        int start = 0;

        int end = sourceArray.length;

        while (start < end ){
            int middle = sourceArray[(start + end)/2];
            if(sourceArray[middle] > value){
                start = middle;
            }
            else if(sourceArray[middle] < value){
                end = middle;
            }else{
                return middle;
            }
        }

        return  -1;
    }
}
