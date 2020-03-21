package com.miller.datastructure.search;

import java.util.ArrayList;

public class Fibonacci {

    public static int max_size = 20;

    public static void main(String[] args) {
        int[] arrs = new int[max_size];
        Fibonacci fibonacci = new Fibonacci(arrs);
        for (int e: arrs
             ) {
            int i = 0;
            System.out.println("遍历第" + i + "个数是： " + e);
            i++;
        }
    }

   public  Fibonacci( int[] arrs) {
        arrs[0] = 0;
        arrs[1] = 1;
        for(int i = 2; i < max_size; i ++) {
            arrs[i] = arrs[i-2] + arrs[i-1];
        }
    }

    //下面实现斐波那契查找--- java版的怎么写？

}
