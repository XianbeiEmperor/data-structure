package com.miller.datastructure.tree;

import java.util.TreeMap;

//使用键值有序排列的映射表
//解析源码的网址： https://www.jianshu.com/p/e11fe1760a3d
public class UseTreeMap {

    //底层使用红黑是实现，既能解决提高磁盘读写性能的问题，又解决查询效率低的问题
    //怎么用，先new一个来玩玩
    private TreeMap<String ,Object> treeMap = new TreeMap<>();

    //向映射表添加数据
    public void addElement(Student student) {
        treeMap.put(student.getId(),student);
    }

    //从映射表中查找元素
    public Student getStudentByKey(String key) {
        if(treeMap.containsKey(key))
        return (Student) treeMap.get(key);
        else
            return null;
    }

    //从映射表中删除一个元素
    public Student deleteStudentByKey(String key) {
        return (Student) treeMap.remove(key);
    }

    //修改一个元素
    public Student updateStudent(Student student) {
        return (Student) treeMap.replace(student.getId(), student);
    }

    //返回第一个
    public Student getFirst() {
        return (Student) treeMap.firstEntry();
    }
    //返回最后一个
    public Student getLast() {
        return (Student) treeMap.lastEntry();
    }

    //返回某一个范围的集合
    public TreeMap<String,Object> getSubTreeMap(String sKey, String eKey) {
        return (TreeMap<String, Object>) treeMap.subMap(sKey,eKey);
    }
    //对每一个映射执行指定操作怎么玩？
    //利用 forEach方法

    /*
    * HashMap可实现快速存储和检索，但其缺点是其包含的元素是无序的，这导致它在存在大量迭代的情况下
    * 表现不佳。
    * LinkedHashMap保留了HashMap的优势，且其包含的元素是有序的。它在有大量迭代的情况下表现更好。
    * TreeMap能便捷的实现对其内部元素的各种排序，但其一般性能比前两种map差。
    * */
}
