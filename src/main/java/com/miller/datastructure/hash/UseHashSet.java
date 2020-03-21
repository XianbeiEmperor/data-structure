package com.miller.datastructure.hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//使用HashSet
public class UseHashSet {

    private HashSet<Integer> set;

    public void CreatSet() {
        this.set = new HashSet<Integer>();
    }

    //无序的散列表 --添加一个元素到散列表中
    public void addElement(Integer element) {
        set.add(element);
    }

    //查找某个元素是不是在集合中
    public boolean queryElement(Integer e) {
        return set.contains(e);
    }

    //删除一个元素
    public void deleteElement(Integer e) {
        set.remove(e);
    }

    public static void main(String[] args) {
        Set<String> words = new HashSet<String>();
        long totalTime = 0;
        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                String word = in.next();
                if("#".equals(word)) {
                    break;
                }
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for(int i =1; i<=20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println("...");
        System.out.println(words.size() + "distinct words" + totalTime + "milliseconds" );
    }
}
