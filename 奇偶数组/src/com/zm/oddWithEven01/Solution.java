package com.zm.oddWithEven01;

/*
 * 方法1：冒泡排序法的思路  (数组中奇数与奇数之间，偶数与偶数之间的相对位置不变)
 *    用两层for循环遍历数组。外层控制轮数，内层控制比较的次数。若当前遍历的数是偶数，它的后一个数是
 *  奇数，则将这两个数交换
 * */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void reOrderArray(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {//外层控制轮数
            for (int j = 0; j < len - i - 1; j++) {//内层控制比较的次数
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
