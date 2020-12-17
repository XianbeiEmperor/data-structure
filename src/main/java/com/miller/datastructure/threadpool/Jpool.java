package com.miller.datastructure.threadpool;

import java.util.concurrent.*;

/**
 * @program: data-structure
 * @description: java thread pool create
 * @author: Miller.FAN
 * @create: 2020-12-17 21:35
 **/
public class Jpool {

    private static ThreadPoolExecutor threadPoolExecutor;

    public Jpool(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    //监控线程池
    //线程中需要执行的任务数量
    public long getTaskCount() {
        return this.threadPoolExecutor.getTaskCount();
    }
    //返回线程池中线程的数量
    public long getPoolSize() {
        return this.getThreadPoolExecutor().getPoolSize();
    }

    //使用单例模式创建一个线程池，并初始化一个线程池
    public ThreadPoolExecutor getAnPool() {
        //需要传入队列保存任务，而队列的类型有
        BlockingQueue queue = new ArrayBlockingQueue<>(30);
        RejectedExecutionHandler defaultHandler =
                new ThreadPoolExecutor.AbortPolicy();
        return new ThreadPoolExecutor(10,100,
                1000,TimeUnit.MINUTES,queue,defaultHandler);
    }

    //开始使用线程池
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue<>(30);
        RejectedExecutionHandler defaultHandler =
                new ThreadPoolExecutor.AbortPolicy();
        //创建一个线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,100,
                1000,TimeUnit.MINUTES,queue,defaultHandler);
        //使用线程池
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int cpus = Runtime.getRuntime().availableProcessors();
                System.out.println("miller's computer's cpu size :{}" + cpus);
            }
        });

        //立刻停止线程池
        //pool.shutdownNow();

    }

}
