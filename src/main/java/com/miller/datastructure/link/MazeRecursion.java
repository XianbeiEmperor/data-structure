package com.miller.datastructure.link;

//迷宫的递归实现
public class MazeRecursion {
    //传入一个迷宫，即初始化完成的二维数组；

    //递归法实现这种"穷举"法探索

    //如何找到最短路径---迷宫的最短路径

    //设计迷宫的递归算法，关键是将问题求解过程拆分成可以重复进行的小问题

    //定义一个二维数组，代表迷宫
    private int[][] maze;

    private Stack stack = new Stack();

    public void init(int[][] maze) {
        this.maze = maze;
        //初始化栈
        stack.InitStack();
    }

    public void findPath(int start_x1, int start_y1, int end_x2, int end_y2, int neighbor) {
        //（start_x1，start_y1）入栈
        //入口
        int nextPotion;
        if(neighbor == 4) {
            nextPotion = -1;
        }
        else {
            nextPotion = neighbor;
        }
        int line = 0;
        int column = 0;
        Path entry = new Path(1, 1);
        stack.push(entry);  //将入口压入栈中
        maze[start_x1][start_y1] = -1;  //入口置成-1，防止重复搜索，考虑该方法下有没有必要？
        while(nextPotion < 4) {
            nextPotion++;
            Path top = (Path) stack.topObject();
            switch (nextPotion) {
                case 0:
                    line = top.x - 1;
                    column = top.y;
                    break;
                case 1:
                    line = top.x;
                    column = top.y + 1;
                    break;
                case 2:
                    line = top.x + 1;
                    column = top.y;
                    break;
                case 3:
                    line = top.x;
                    column = top.y - 1;
                    break;
            }
/*            if (maze[line][column] == 0) {
                find = 1;
            }*/
            if(line == end_x2 && column == end_y2 ) {
                //找到了出口，入栈，并且打印结果
                Path node = new Path(line, column);
                stack.push(node);
                System.out.println("迷宫路径如下： " + "\n");
                System.out.println("栈内元素个数： " + stack.getSize());
                int max = stack.getSize();
                for (int k = 0; k < max; k++) {
                    //栈逆转成队列
                    Path out = (Path) stack.orderPop();
                    System.out.println("(" + out.x + " , " + out.y + ")；   ");
                    if ((k + 1) % 5 == 0) { //每行5个元素，然后换行
                        System.out.println("\n");
                    }
                }
                System.out.println("\n");
                return;
            }
            else {
                if(maze[line][column] == 0) {
                    //该位置入栈
                    Path p = new Path(line,column);
                    stack.push(p);
                    //递归调用
                    findPath(line,column,end_x2,end_y2,-1);
                }
            }
        }
        //未找到相邻可走路径时可以回溯
        maze[start_x1][start_y1] = 2;
        System.out.println("没有可走的路径！");
    }
//教材上这个算法有个致命的错误，没有找到可以回溯，然后简单的将对应位置回置成0，
// 下次搜索是还回进入到这个死胡同--- 无限死循环
}
