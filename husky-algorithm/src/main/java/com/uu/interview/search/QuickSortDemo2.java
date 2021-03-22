package com.uu.interview.search;

/**
 * @author liuph  参见文章： https://www.seotest.cn/jishu/44475.html
 * @desc 快速排序demo
 * @date 2021/03/02 17:57
 */
public class QuickSortDemo2 {

    public static int getBasePoint(int[] sourceArray ,int low,int high){
        int basePoint = low;


        while (low < high){
           while (sourceArray[low] < basePoint){
                low++;
           }
           while (sourceArray[high] > basePoint){
                high++;
           }
           int temp = sourceArray[low];
           sourceArray[low] = sourceArray[high];
           sourceArray[high] = temp;
       }

       return low;

    }

    public static void  quickSort(int[] sourceArray,int low,int high){
        if(high > low){

            int basePoint = getBasePoint(sourceArray, low, high);
            quickSort(sourceArray,low,basePoint-1);
            quickSort(sourceArray,basePoint + 1,high);
        }
    }

}


