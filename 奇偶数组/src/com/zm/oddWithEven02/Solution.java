package com.zm.oddWithEven02;


/*
 * 方法2：插入排序的思想。
 *     1）用k记录已排好的奇数个数
 *     2）将数组从左往右遍历，找到遍历数组中的第一个奇数。用临时变量记录这个数，将它与前面的数进行交换
 * */
public class Solution {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 7, 8, 5, 6, 8};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void reOrderArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return;
        }
        int k = 0; //记录已排的奇数的个数
        //遍历数组，找到出现的第一个奇数的位置，并用k记录已经摆好的奇数的个数
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1) {//如果这个数是奇数，则记录下出现奇数的下标
                int j = i;
                while (j > k) {//将偶数与奇数交换
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    j--;
                }
                k++;
            }
        }
    }
}
