package com.miller.datastructure;

import com.miller.datastructure.link.LinkList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;

@SpringBootApplication
public class DataStructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStructureApplication.class, args);
        LinkList oneList = new LinkList();
        oneList.insertFirst(1,"张飞",112356);
        oneList.insertFirst(2,"关羽",112336);
        oneList.insertFirst(3,"刘备",122356);
        oneList.displayList();
        System.out.println("找到的某个元素： " + oneList.findOne(1).toString());
        oneList.delete(1);
        oneList.displayList();

        //java中已经实现的链表
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("fengzhenbiao");
        linkedList.add("miller");
        boolean ret =  linkedList.contains("miller");
        System.out.println(ret);
    }

}
