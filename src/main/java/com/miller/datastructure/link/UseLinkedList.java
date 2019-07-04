package com.miller.datastructure.link;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class UseLinkedList {

    //可以方便的在任何位置插入或删除元素的有序序列
    /*
    * 随机访问慢，但是删除和插入元素比较快
    * */

    /*
    * LinkedList是通过双向链表去实现的，既然是链表实现那么它的随机访问效率比ArrayList
    * 要低，顺序访问的效率要比较的高。
    * LinkedList是一个功能很强大的类，可以被当作List集合，双端队列和栈来使用
    * */
    LinkedList<Student> linkedList = new LinkedList<>();

    public void addElement(Student student) {
        linkedList.add(student);
    }





    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

 /*       list.add(2);
        list.add(10);
        list.add(1);
        list.add(6);*/
        addList(2,list);
        addList(10,list);
        addList(1,list);
        addList(6,list);
;        System.out.println(list);
        System.out.println(list);
    }

    //如何保证插入的元素是有序的，插入之前进行比较，然后在指定位置上插入？
    static void addList(int i, LinkedList list) {
        int j=0;
        for (Object integer : list) {
            if ((Integer)integer>i) {
                break;
            }
            j++;
        }
        list.add(j, i);
    }

    //请使用 LinkedList 模拟一个堆栈或队列的数据结构？

    class Queue {
        private LinkedList link;
        public Queue() {
            link = new LinkedList();
        }
        public void push(Object obj) {
            link.addLast(obj);
        }

        public Object pop() {
            return link.removeFirst();
            //队列
            // return link.removeLast();
            // 堆栈
        }
        public boolean isEmpty() {
            return link.isEmpty();
        }
    }

}
