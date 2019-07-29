package pers.javaSE.threadPool;

import java.util.concurrent.*;

public class ExecutorsDemo {

    public static void main(String[] args){
//        testSingleThreadPool();
        testDefineThreadPoll();
    }


    public static void testDefineThreadPoll(){
        // 创建等待队列
        BlockingQueue bqueue = new ArrayBlockingQueue(20);
        // 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,3,4,TimeUnit.MILLISECONDS,bqueue);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        for (int i = 0; i <= 9; i++) {
            // 将线程放入池中进行执行
            pool.execute(new MyThread2(i));
        }
        // 关闭线程池
        pool.shutdown();

    }


    public static void testFixedThreadPool(){
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i=0;i<9;i++){
            pool.execute(new MyThread(i));
        }
        pool.shutdown();
    }

    public static void testSingleThreadPool(){
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i=0;i<9;i++){
            pool.execute(new MyThread(i));
        }
        pool.shutdown();
    }
}

class MyThread extends Thread {
    int num;
    public MyThread(int i){
        this.num = i;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行..." + this.num);
    }
}

class MyThread2 extends Thread {
    int num;
    public MyThread2(int i){
        this.num = i;
    }
    @Override
    public void run() {
        System.out.println(this.num+" 正在被"+Thread.currentThread().getName() + "执行。。。");
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}