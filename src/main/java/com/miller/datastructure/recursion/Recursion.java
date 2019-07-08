package com.miller.datastructure.recursion;

//递归算法研究
public class Recursion {

    //递归法 大问题化成小问题，遇到递归出口后发生“质变“
    public static int function(int n) {
        if(n ==1) {
            return 1;
        }
        else{
            return (n*function(n-1));
        }
    }

    //循环法
    public static int functionOne(int n) {
        int ret = 1;
        for(int i =1; i<=n; i++) {
            ret = ret * i;
        }
        return ret;
    }

    //斐波那契数列
    public static int Fibonacci(int n) {
        int f1 = 1;
        int f2 = 1;
        if(n == 1 || n == 2)
            return 1;
        else {
            return (Fibonacci(n-1) + Fibonacci(n-2));
        }
    }


    public static void main(String[] args) {
        function(10);
        System.out.println("求n的阶层：" + function(10));
        functionOne(10);
        System.out.println("循环法求n的阶层：" + functionOne(10));

        System.out.println("斐波那契额数列 ：" + Fibonacci(10));
        int n =10;
        for(int l =1; l <= n; l ++) {
            System.out.println("斐波那契额数列 ：" + Fibonacci(l));
        }
    }

    //迷宫问题也可以设计成递归方式---重点在看待问题得到角度上。 递归算法的时间效率比较差
    //因此，我们希望用递归算法分析问题，用非递归算法求解问题。

}
