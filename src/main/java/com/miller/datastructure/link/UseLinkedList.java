package com.miller.datastructure.link;

import com.sun.jmx.snmp.internal.SnmpSubSystem;

import java.util.Collections;
import java.util.LinkedList;


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
/*        LinkedList<Integer> list = new LinkedList<>();

        list.add(2);
        list.add(10);
        list.add(1);
        list.add(6);
        Collections.sort(list);
*//*        addList(2,list);
        addList(10,list);
        addList(1,list);
        addList(6,list);*//*
        ;
        System.out.println(list);
        //Collections.shuffle(list);
        System.out.println(list);
        Integer index = Collections.binarySearch(list, 1);
        System.out.println("找到的Key: " + index);

        Collections.binarySearch(list, 6);*/
        mgPath();

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
    static void mgPath() {
        int line = 0, column = 0, nextPotion = -1, find = 0, k;
        //迷宫求解问题
        //定义一个二维数组，代表迷宫
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        Stack stack = new Stack();
        stack.InitStack();
        //入口
        Position entry = new Position(1, 1, -1);
        maze[1][1] = -1;
        stack.push(entry);  //将入口压入栈中
        while (!stack.isEmpty()) {
            //读取栈顶元素，然后判断是不是出口
            Position top1 = (Position) stack.topObject();
            //找到路径，判断是不是出口
            if (top1.getLineNum() == 8 && top1.getColumnNum() == 8) {
                System.out.println("迷宫路径如下： " + "\n");
                System.out.println("栈内元素个数： " + stack.getSize());
                int max = stack.getSize();
                for (k = 0; k < max; k++) {
                    //栈逆转成队列
                    Position out = (Position) stack.orderPop();
                    System.out.println("(" + out.getLineNum() + " , " + out.getColumnNum() + ")；   ");
                    if ((k + 1) % 5 == 0) { //每行5个元素，然后换行
                        System.out.println("\n");
                    }
                }
                System.out.println("\n");
                return;
            }
            //按照👆、👉、👇、👈的循序查找相邻节点能不能通过
            nextPotion = (((Position) stack.topObject())).getNextPostionNum();
            while (nextPotion < 4 && find == 0) {
                nextPotion++;
                Position top = (Position) stack.topObject();
                switch (nextPotion) {

                    case 0:
                        line = top.getLineNum() - 1;
                        column = top.getColumnNum();
                        break;
                    case 1:
                        line = top.getLineNum();
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
                }
                if (maze[line][column] == 0) {
                    find = 1;
                    System.out.println("入栈前nextPotion  =  " + nextPotion);
                }
               //何时将nextPotion 再次设置成-1 ？
            }
            if (find == 1) {
                if(nextPotion != -1) {
                    Position aPosition = new Position(line, column, nextPotion);
                    System.out.println("入栈的位置信息： " + nextPotion);
                    System.out.println("入栈的位置记录： x =" +  aPosition.getLineNum() + " ,y= " + aPosition.getColumnNum() );
                    stack.push(aPosition);
                    maze[line][column] = -1;
                }

                nextPotion = -1;
                find = 0;
                System.out.println("已经入栈的位置： " +maze[line][column] );
            }
            if(find == 0 && (-1 != nextPotion )) {
                //该位置已经搜索过，该路不同，标记，防止下一次在搜索该处   ---2019.07.08 miller modify
                //maze[line][column] = -1;
                //否则将栈顶元素弹出，修改对应位置的值  。///不应该修改回去
                Position topElemnet = (Position) stack.topObject();
                maze[topElemnet.getLineNum()][topElemnet.getColumnNum()] = 0;
                System.out.println("退栈的位置：" +  "x= " + topElemnet.getLineNum() + " ,y= " + topElemnet.getColumnNum());
                stack.pop();

            }

        }
        //System.out.println("没有可走的路径！");
        System.out.println("    へ　　　　　／|\n" +
                "　　/＼7　　　 ∠＿/\n" +
                "　 /　│　　 ／　／\n" +
                "　│　Z ＿,＜　／　　 /`ヽ\n" +
                "　│　　　　　ヽ　　 /　　〉\n" +
                "　 Y　　　　　`　 /　　/\n" +
                "　ｲ●　､　●　　⊂⊃〈　　/\n" +
                "　()　 へ　　　　|　＼〈\n" +
                "　　>ｰ ､_　 ィ　 │ ／／\n" +
                "　 / へ　　 /　ﾉ＜| ＼＼\n" +
                "　 ヽ_ﾉ　　(_／　 │／／\n" +
                "　　7　　　　　　　|／\n" +
                "　　＞―r￣￣`ｰ―＿");
    }
}

