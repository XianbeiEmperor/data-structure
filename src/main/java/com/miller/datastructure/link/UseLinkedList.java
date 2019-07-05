package com.miller.datastructure.link;

import java.util.Collections;
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

        list.add(2);
        list.add(10);
        list.add(1);
        list.add(6);
        Collections.sort(list);
/*        addList(2,list);
        addList(10,list);
        addList(1,list);
        addList(6,list);*/
        ;
        System.out.println(list);
        //Collections.shuffle(list);
        System.out.println(list);
        Integer index = Collections.binarySearch(list, 1);
        System.out.println("找到的Key: " + index);

        Collections.binarySearch(list, 6);

        //如何保证插入的元素是有序的，插入之前进行比较，然后在指定位置上插入？
/*    static void addList(int i, LinkedList list) {
        int j=0;
        for (Object integer : list) {
            if ((Integer)integer>i) {
                break;
            }
            j++;
        }
        list.add(j, i);
    }*/


    }

    //传递入口和出口
    void mgPath() {
        int line = 0, column = 0, nextPotion = -1, find = 0, k;
        //迷宫求解问题
        //定义一个二维数组，代表迷宫
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        Stack stack = new Stack();
        stack.InitStack();
        //入口
        Position entry = new Position(1, 1, -1);
        stack.push(entry);  //将入口压入栈中
        while (!stack.isEmpty()) {
            //弹出栈顶，然后判断是不是出口
            Position top1 = (Position) stack.pop();
            //找到路径，判断是不是出口
            if (top1.getLineNum() == 8 && top1.getColumnNum() == 8) {
                //将弹出的栈顶再次入栈
                stack.push(top1);
                System.out.println("迷宫路径如下： " + "\n");
                for (k = 0; k <= stack.getSize(); k++) {
                    Position out = (Position) stack.pop();
                    System.out.println("(" + out.getLineNum() + " , " + out.getColumnNum() + ")");
                    if ((k + 1) % 5 == 0) { //每行5个元素，然后换行
                        System.out.println("\n");
                    }
                    System.out.println("\n");
                    return;
                }
            }
            find = 0;
            while (nextPotion < 4 && find == 0) {
                nextPotion++;
                switch (nextPotion) {

                    Position top = (Position) stack.topObject();
                    case 0:
                        line = top.getLineNum() - 1;
                        column = top.getColumnNum();
                        break;
                    case 1:
                        line = top.getLineNum() - 1;
                        column = top.getColumnNum() + 1;
                        break;
                    case 2:
                        line = top.getLineNum() + 1;
                        column = top.getColumnNum();
                        break;
                    case 3:
                        line = top.getLineNum();
                        column = top.getColumnNum() - 1;
                        break;
                    if (maze[line][column] == 0)
                        find = 1;
                }
                if(find ==1) {
                    Position topElemnet = (Position) stack.topObject();
                    topElemnet.setNextPostionNum(nextPotion);
                    Position aPosition = new Position(line,column,-1);
                    stack.push(aPosition);
                    maze[line][column] = -1;
                }
                else {
                    maze[line][column] = 0;
                    stack.pop();
                }

            }
            System.out.println("没有可走的路径！");

        }
    }
}
