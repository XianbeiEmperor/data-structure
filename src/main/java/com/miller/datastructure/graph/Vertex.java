package com.miller.datastructure.graph;

//vertex 翻译：顶点
public class Vertex {
    public char lable;
    public boolean wasVisited;

    public Vertex(char lable) {
        this.lable = lable;
    }

    public Vertex(char lable, boolean wasVisited) {
        this.lable = lable;
        this.wasVisited = wasVisited;
    }
}
