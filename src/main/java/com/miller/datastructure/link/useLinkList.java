package com.miller.datastructure.link;

public class useLinkList {

    public static void main(String[] args) {
         LinkList oneList = new LinkList();
         oneList.insertFirst(1,"张飞",112356);
         oneList.insertFirst(2,"关羽",112336);
         oneList.insertFirst(3,"刘备",122356);
         oneList.displayList();
    }
}
