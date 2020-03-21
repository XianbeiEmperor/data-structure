package com.miller.datastructure.search;

public class Search {

    //顺序查找---自己写的
    public int SeqSearch(int arrs[], int key) {
        for(int i=0; i< arrs.length; i++) {
            if(arrs[i] == key) {
                return i;
            }
        }
        return -1;
    }

    //顺序查找---人家实现的
    public int lineSearch(int searchKey, int arrs[], int n){
        for(int i = 0 ; i < n; i++){
            if(arrs[i] == searchKey){
                return i;
            }
        }
        return -1;
    }



    //折半查找，适合处理顺序表，不适合处理链表
    public int binSearch(int value, int arrs[], int n){
        int mid = 0;
        int low = 0;
        int pow = n;
        while(true){
            mid = ( low + pow) / 2;
            if(arrs[mid] == value){
                return mid;
            }else if(low > pow){
                return -1;
            }else{
                if(arrs[mid] < value){
                    low = mid + 1;
                }else{
                    pow = mid - 1;
                }
            }
        }
    }

    //二分查找，递归版本
    public int BinarySearch2(int a[], int value, int low, int high) {
        int ret =-1;
        int mid = low+(high-low)/2;
        if(a[mid]==value)
            ret = mid;
        if(a[mid]>value)
            ret = BinarySearch2(a, value, low, mid-1);
        if(a[mid]<value)
            ret = BinarySearch2(a, value, mid+1, high);
        return ret;
    }

    //自己写的折半查找法
    public int BinSrarch(int arrs[], int key) {
        int low = 0, high = arrs.length - 1, mid;
        int ret =0;
        //while条件有问题
        while(low < high) {
            mid = (low + high)/2;
            if(key == arrs[mid])
                ret =  mid;
            else if(key > arrs[mid]) {
                low = mid +1;
            }
            else if(key < arrs[mid]) {
                high = mid -1;
            }
            else {
                ret =  -1;
            }
        }
        return ret;
    }
    //升级版
    public int BinSrarch1(int arrs[], int key) {
        int low = 0, high = arrs.length - 1, mid;
        while(low <= high) {
            mid = (low + high)/2;
            if(key == arrs[mid])
                return mid;
            else if(key > arrs[mid]) {
                low = mid +1;
            }
            else if(key < arrs[mid]) {
                high = mid -1;
            }
        }
        return -1;
    }

    /*
    * 在介绍插值查找之前，首先考虑一个新问题，为什么上述算法一定要是折半，而不是折四分之一或者折更多呢？
　　打个比方，在英文字典里面查“apple”，你下意识翻开字典是翻前面的书页还是后面的书页呢？如果再让你查“zoo”，你又怎么查？很显然，这里你绝对不会是从中间开始查起，而是有一定目的的往前或往后翻。
　　同样的，比如要在取值范围1 ~ 10000 之间 100 个元素从小到大均匀分布的数组中查找5， 我们自然会考虑从数组下标较小的开始查找。
　　经过以上分析，折半查找这种查找方式，不是自适应的（也就是说是傻瓜式的）。二分查找中查找点计算如下：
　　mid=(low+high)/2, 即mid=low+1/2*(high-low);
　　通过类比，我们可以将查找的点改进为如下：
　　mid=low+(key-a[low])/(a[high]-a[low])*(high-low)，
　　也就是将上述的比例参数1/2改进为自适应的，根据关键字在整个有序表中所处的位置，让mid值的变化更靠近关键字key，这样也就间接地减少了比较次数。
　　基本思想：基于二分查找算法，将查找点的选择改进为自适应选择，可以提高查找效率。当然，差值查找也属于有序查找。
    * */
    //插值查找算法---
    //在海量数据的情况下，查找效率优于折半查找，虽然其时间复杂度也为O（logn）
    public static int interpolationSearch(int nums[], int value){
        int low = 0, mid, high = nums.length - 1;
        while(low <= high){
            //与二分查找的区别点，在mid的选择
            mid = low + (high-low)*(value - nums[low]) / (nums[high] - nums[low]);
            if(nums[mid] == value){
                return mid;
            }
            if(nums[mid] > value){
                high = mid - 1;
            }
            if(nums[mid] < value){
                low = mid + 1;
            }
        }
        return -1;
    }

    //插值查找 --- 递归实现
    int InsertionSearch(int a[], int value, int low, int high)
    {
        int ret =-1;
        int mid = low+(value-a[low])/(a[high]-a[low])*(high-low);
        if(a[mid]==value)
            ret =  mid;
        if(a[mid]>value)
            ret = InsertionSearch(a, value, low, mid-1);
        if(a[mid]<value)
            ret = InsertionSearch(a, value, mid+1, high);
        return ret;
    }


}
