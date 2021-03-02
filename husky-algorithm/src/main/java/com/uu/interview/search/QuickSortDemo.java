package com.uu.interview.search;

/**
 * @author liuph  参见文章： https://www.seotest.cn/jishu/44475.html
 * @desc 快速排序demo
 * @date 2021/03/02 17:57
 */
public class QuickSortDemo {


    // 选择 基准点 ，两边同时进行
    public static int sort(int sourceArray[], int low, int high) {
        int baseValue = sourceArray[low];
        while (low < high) {
            while (low < high && sourceArray[low] < baseValue) {
                low++;
            }
            while (low < high && sourceArray[high] > baseValue) {
                high--;
            }
            // 交换
            int temp = sourceArray[low];
            sourceArray[low] = sourceArray[high];
            sourceArray[high] = temp;
        }
        return low;
    }

    public static void quickSort(int[] sourceArray, int low, int high) {
        if (low < high) {
            //
            int baseIndex = sort(sourceArray, low, high);
            quickSort(sourceArray, low, baseIndex - 1);
            quickSort(sourceArray, baseIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{4, 5, 1, 2, 6, 3};
        quickSort(sourceArray, 0, sourceArray.length - 1);

        for (int i = 0; i < sourceArray.length; i++) {
            System.out.println(sourceArray[i]);
        }
    }

}


