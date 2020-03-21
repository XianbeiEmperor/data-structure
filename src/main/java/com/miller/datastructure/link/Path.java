package com.miller.datastructure.link;

public class Path {
    public int x;
    public int y;

    public Path(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Path{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
