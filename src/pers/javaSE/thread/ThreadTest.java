package pers.javaSE.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadTest {
    public static void main(String[] args){

//       testThreadInfo();
//        testSleepMethod();
        testWaitMethod();

    }

    public static void testWaitMethod(){

        // 创建wait方法相关的类
       WaitThread waitThread = new WaitThread();
       Thread thread1 = new Thread(waitThread,"thread1");
       Thread thread2 = new Thread(waitThread,"thread2");
       thread1.start();
       thread2.start();

    }

    /*
    * wait方法，是对象中的方法，其实现必须与synchronize关键字一起，联合使用才行！
    *
    * */
    static class WaitThread implements Runnable {
        int count = 0;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Say Hello WaitSleep!");
            add();
        }

        public void add(){
            while (count<20){
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + "-->count:" + count);
                    try {
                        count++;
                        this.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void testSleepMethod(){

        class SleepTestThread implements Runnable{
            int count = 0;
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Hello, I am SleepTestThread");
//                count1();
                count2();
            }

             void count1(){
                while (count<20){
                    System.out.println(Thread.currentThread().getName()+" --> The count is"+count);
                    try {
                        count++;
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

             void count2(){
                while (count<20){
                    synchronized (this) {
                        System.out.println(Thread.currentThread().getName() + "--->The count is" + count);
                        try {
                            count++;
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        System.out.println("Begin test SleepMethod");
        SleepTestThread sleepTestThread = new SleepTestThread();
        Thread thread1 = new Thread(sleepTestThread,"thread1");
        Thread thread2 = new Thread(sleepTestThread,"thread2");
        thread1.start();
        thread2.start();
        System.out.println("test is over");


    }



    public static void testThreadInfo(){
        // 获取线程管理对象
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo info:threadInfos){
            System.out.println("["+info.getThreadId()+"]"+info.getThreadName());
        }
    }
}
