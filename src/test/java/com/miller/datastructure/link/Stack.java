package com.miller.datastructure.link;

import org.junit.Test;

import java.util.LinkedList;


//请使用 LinkedList 模拟一个堆栈或队列的数据结构？
//双向链表实现
public class Stack {
    private LinkedList link;
    //该栈具有自动扩容的能力
    public Stack() {
        link = new LinkedList();
    }
    //入栈
    public void push(Object obj) {
        link.addLast(obj);
    }
    //出栈
    public Object pop() {
        //队列
        //return link.removeFirst();
        // 堆栈
        return link.removeLast();

    }
    //判断栈空
    public boolean isEmpty() {
        return link.isEmpty();
    }
    //初始化栈
    public void  InitStack() {
        link.clear();
    }
    //返回栈中元素的个数
    public int getSize() {
        return link.size();
    }

    //获取栈顶元素，但是不出栈
    public Object topObject() {
        return link.getLast();
    }

    @Test
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(5);
        st.push(6);
        st.push(4);
        Integer out = (Integer) st.pop();
        System.out.println("出栈的元素是： " + out);
        int size = st.getSize();
        System.out.println("栈内的元素个数是： " + size);
        st.push(3);
        // st.topObject();
        System.out.println("栈顶元素是： " +  st.topObject());
        System.out.println("栈内的元素个数是： " + st.getSize());
    }
}


