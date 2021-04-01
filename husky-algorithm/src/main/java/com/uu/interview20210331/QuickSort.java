package com.uu.interview20210331;

/**
 * @author liuph
 * @desc
 * @date 2021/03/31 21:59
 */
public class QuickSort {
    
    // 快排
    //  1. 选举基准点 ，左比大  右比小，交换
    
    public static int getBasePoint(int[] sourceArray,int left,int right){
        // 选择基准点
        int baseValue = sourceArray[left];
        
        while (left < right){
            while(sourceArray[left] < baseValue){ // --> 大于 跳出
                left++;
            }
            while (sourceArray[right] > baseValue){ // -->  小于跳出
                right--;
            }
            // 交换
            int temp = sourceArray[left];
            sourceArray[left] = sourceArray[right];
            sourceArray[right] = temp;
        }
        return left;
    }
    
    public static void quickSort(int[] sourceArray,int left ,int right){
        if (left < right){
            // 依据基准点 二分法处理
            int basePoint = getBasePoint(sourceArray, left, right);
            quickSort(sourceArray,left,basePoint - 1);
            quickSort(sourceArray, basePoint + 1, right);
        }
    }
    public static void main(String[] args) {
        int [] sourceArray = {2,3,1,6,4,5};
        quickSort(sourceArray,0,sourceArray.length - 1);

        for (int i = 0; i < sourceArray.length; i++) {
             System.out.println(sourceArray[i]);
        }
    }
}
