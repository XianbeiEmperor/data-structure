package com.miller.datastructure.hash;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

//哈希表怎么玩？
/*
* 　　什么是哈希函数？
　哈希函数的规则是：通过某种转换关系，使关键字适度的分散到指定大小的的顺序结构中，
* 越分散，则以后查找的时间复杂度越小，空间复杂度越高
* */
public class Map {
    //线程不安全的
    HashMap<String, Object> ret  = new HashMap<>();

    //线程安全的
    ConcurrentHashMap hashMap = new ConcurrentHashMap();
}
