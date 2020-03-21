package com.miller.datastructure.queue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class UseQueue {
    //如果我想使用一个循环队列
    private ArrayDeque arrayDeque = new ArrayDeque();

    //在循环队列中加一个元素
    public void addElement(int value) {
        arrayDeque.add(value);
    }

    //从循环队列中移除一个元素
    public void removeElement(int value) {
        arrayDeque.remove(value);
    }

    //返回当前队列的容量
    public int getSize() {
        return arrayDeque.size();
    }

    //返回第一个元素
    public void getTheFirsrtElement() {
        arrayDeque.peekFirst();
    }

    //ArrayDeque支持从头尾两端删除元素  他是用数组实现的双端队列，是循环队列
    //常用英文单词---peek 查询  offer 插入   poll 删除

    public void  dispalyElements() {
        Iterator<Object> iterator =  arrayDeque.iterator();
        if(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
