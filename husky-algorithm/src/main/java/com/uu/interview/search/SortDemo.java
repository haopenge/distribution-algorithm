package com.uu.interview.search;

/**
 * @author liuph
 * @desc 排序demo
 * @date 2021/03/02 16:52
 */
public class SortDemo {


    /**
     * @desc  插入排序
     * @author liuph
     * @date  2021/03/02 17:24
     */
    public static int[] insertSort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++) {

            int temp = sourceArray[i];
            int j = i;
            while (j > 0 && temp < sourceArray[j-1]){
                // 前移
                sourceArray[j] = sourceArray[j-1];
                j--;
            }

            if(j != i){
              sourceArray[j] = temp;
            }

        }
        return sourceArray;

    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{6, 5, 1, 2, 3};
        int[] sortArray = insertSort(sourceArray);

        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sourceArray[i]);
        }
    }
}
