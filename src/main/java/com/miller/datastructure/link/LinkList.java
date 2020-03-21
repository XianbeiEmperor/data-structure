package com.miller.datastructure.link;

public class LinkList {

    //列表中唯一需要维护的变量
    private Student first;

    //将初始化明确写出来，其实不写这个也没关系
    public void LinkList() {
        this.first = null;
    }

    //判断列表是不是空的
    public boolean isEmpty() {
        return (first == null);
    }


    //新增一个节点
    public void insertFirst(long id, String name, long phoneNumber) {
        Student student = new Student(id, name, phoneNumber);
        student.next = first;
        first = student;
    }


    //新增一个节点， 直接传入节点对象
    public void insertFirst(Student student) {
        // Student student = new Student(id, name, phoneNumber);
        student.next = first;
        first = student;
    }

    //删除头节点
    public Student deleteFirst() {
        Student temp = first;
        first = first.next;
        return temp;
    }

    //删除某一个节点的方法
    public Student delete(long key) {
        Student current = first;
        Student previous = first;
        while (current.getId() != key) {
            if (current == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        } // 找到了相应的节点，跳出while循环
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;   // bypass it
        }
        return current;
    }

    //查找一个节点
    public Student findOne(long key) {
        Student current = first;
        try {
            while (current.getId() != key) {
                if (current == null) {
                    return null;
                } else {
                    current = current.next;
                }
            } // 找到了相应的节点，跳出while循环
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return current;
    }

    //遍历一个链表
    public void displayList() {
        Student current = first;
        while (current != null) {
            current.dispalyStudent();
            current = current.next;
        }
        System.out.println("\n");
    }
}
