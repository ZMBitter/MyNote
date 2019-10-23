package com.zm.demo;


import java.util.Scanner;


    /*
    我的思路：
       判断所输入的字符串中是否包含非数字字符，如果包含，则返回0；否则，返回该字符串所对应的数
     */

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String read = in.nextLine();
        String target = read.trim();
        long result = strToInt(target);
        System.out.println(result);
    }

    /*
     * @param target 代转换的字符串
     * */
    public static int strToInt(String target) {
        int len = target.length(); //字符串的长度
        int isNegtive = 1; //正负标记位
        int overValue = 0; //表示当前的值与INT_MAX/10的差
        int digit = 0;//表示访问到的这个字符所代表的数
        int value = 0; //当前值

        if (len == 0) {
            return 0;
        }

        //---------------------------------------------------------------------------------
        //设置起始遍历位置。当第一位是符号位（+/-）时，起始坐标从1开始
        if (len > 0 || (target != null && !target.equals(""))) {
            int i = 0;
            if (target.charAt(0) == '-') {
                isNegtive = -1;  //正负符号标记位。+:1  -: -1
                i = 1;
            } else if (target.charAt(0) == '+') {
                i = 1;
            } else { //当第一位是非符号位时，起始坐标从0开始
                i = 0;
            }

            for (; i < len; i++) {
                //将数字字符串的每一位都转换成数字
                digit = target.charAt(i) - '0';

               /*
               判断每轮中转换后的结果是否会越界。overValue>0，越界；overValue < 0 时，不越界，而当 overValue == 0 时：
                正数时（isNegtive == 1），digit > 7 越界，负数时（isNegtive == -1），digit > 8 越界，通过 (isNegtive+1)/2
                来将 -1、1转换为0、1，从而使有关 digit 的判断统一转化为：当 (isNegtive+1)/2 + digit > 8 时，数值越界；
                */

                //(isNegtive+1)/2 将-1、1转换成0、1
                overValue = isNegtive * value - Integer.MAX_VALUE / 10 + (((isNegtive + 1) / 2 + digit > 8) ? 1 : 0);
                if (digit < 0 || digit > 9) {//字符串数组中包含了非数字
                    return 0;
                } else if (overValue > 0) {//越界
                    return 0;
                }
                value = value * 10 + isNegtive * digit;
            }
        }
        return value;
    }
}

