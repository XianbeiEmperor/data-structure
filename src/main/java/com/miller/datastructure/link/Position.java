package com.miller.datastructure.link;

public class Position {
    private int lineNum; //行号
    private int columnNum; //列号
    private int nextPostionNum; //下一步可走方位的方向号

    public Position() {
    }

    public Position(int lineNum, int columnNum, int nextPostionNum) {
        this.lineNum = lineNum;
        this.columnNum = columnNum;
        this.nextPostionNum = nextPostionNum;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getNextPostionNum() {
        return nextPostionNum;
    }

    public void setNextPostionNum(int nextPostionNum) {
        this.nextPostionNum = nextPostionNum;
    }

    @Override
    public String toString() {
        return "Position{" +
                "lineNum=" + lineNum +
                ", columnNum=" + columnNum +
                ", nextPostionNum=" + nextPostionNum +
                '}';
    }
}