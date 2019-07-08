package com.miller.datastructure.graph;

//java中有关图这种数据结构到底怎么用
public class Graph {
    //首先应该有顶点类

    //其次将顶点类组织起来，体现出他们之间的关系

    //我们用一个二维数组就可以表示出来这种复杂关系

    //这个二维数组代表的就是邻接矩阵

    //另一种表示边的方法是邻接表  --- 表示：当前顶点与哪些顶点连接。


    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVertes;

    //构造器---使用了一个邻接表
    public Graph() {
        vertexList = new  Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVertes = 0;
        for(int i =0; i < MAX_VERTS; i++)
            for(int j = 0; j< MAX_VERTS; j++)
                adjMat[i][j] = 0;
    }

    //添加一个顶点到数组中
    public void addVertex(char lab){
        vertexList[nVertes++] = new Vertex(lab);
    }

    //添加边的矩阵中
    public void addEdge(int start ,int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    //显示某个顶点的信息
    public void displayVertex(int v) {
        System.out.println(vertexList[v].lable);
    }
}
