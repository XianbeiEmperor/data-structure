package com.miller.datastructure.sort;

//冒泡法排序
public class ArrayBub {

    private long[] a;
    private int nElement;

    //构造器
    public ArrayBub(int max) {
        a = new long[max];
        nElement = 0;
    }

    //put element into array
    public void insert(long value) {
        a[nElement] = value;
        nElement++;
    }

    //遍历打印数组中的每一个元素
    public void disPlay() {
        int i =0;
        for (long element: a
             ) {
            System.out.println("第" + i + "个元素： " + element);
            i++;
        }
    }

    //自己写的好像不是冒泡法
    public void bubbleSort() {
        long temp = 0;
        for(int i = 0; i <= a.length -1; i++) {
            int j;
            for(j = i +1 ; j< a.length; j++) {
                if(a[i] > a[j] ) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    //人家的冒泡法是真的
    public static void sort(int[] a) {
        //外层循环控制比较的次数
        for (int i = 0; i < a.length - 1; i++) {
            //内层循环控制到达位置
            for (int j = 0; j < a.length - i - 1; j++) {
                //前面的元素比后面大就交换
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    //人家写的快速排序---升序
    public static void sort(int[] a, int low, int high) {
        //已经排完
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        //保存基准值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素
            while (left < right && a[right] >= pivot)
                right--;
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot)
                left++;
            a[right] = a[left];
        }
        // 放置基准值，准备分治递归快排
        a[left] = pivot;
        sort(a, low, left - 1);
        sort(a, left + 1, high);
    }

    /**
     * @param a
     * 人家写的堆排序的算法
     */
    public static void sort2(int[] a) {

        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);

            //堆顶元素(第一个元素)与Kn交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }

    /***
     *
     *  将数组堆化
     *  i = 第一个非叶子节点。
     *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     *
     * @param a
     * @param n
     */
    public static void max_heapify(int[] a, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && a[child] < a[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (a[i] < a[child]) {
                int temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }

    //希尔排序---增量式排序
    public static void shellSort(int[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < a.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }
                }
            }
        }
    }

    //基数排序   ---人家写的  体现分配和收集的过程
    public static void CardinalSort(int[] arr) {
        if (arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            //System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }

    public static void main(String[] args) {
/*        ArrayBub arrayBub = new ArrayBub(6);
        arrayBub.insert(12);
        arrayBub.insert(10);
        arrayBub.insert(15);
        arrayBub.insert(9);
        arrayBub.insert(6);
        arrayBub.insert(2);
        arrayBub.disPlay();
        arrayBub.bubbleSort();
        System.out.println("_____________________");
        arrayBub.disPlay();*/

         int[] a = {2,6,7,8,9,4,1};
         for(int i =0; i< a.length; i++) {
             System.out.println("第" + i + "个数：" + a[i]);
         }
         sort(a,0,6);
        for(int i =0; i< a.length; i++) {
            System.out.println("第" + i + "个数：" + a[i]);
        }
    }
//https://www.cnblogs.com/morethink/  八大排序算法的博客，写的很好，可以用作教学了。
    //https://www.cnblogs.com/morethink/p/8419151.html
}
