package pers.javaSE.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static ReentrantLock lock = new ReentrantLock(false);
    static Condition notEmpty = lock.newCondition();
    static Condition notFull = lock.newCondition();
    static Condition condition = lock.newCondition();

    public static void main(String[] args){
//        for (int i=0;i<5;i++){
//            new Thread(new ThreadDemo(i)).start();
//        }
        lock.lock();
        System.out.println("主线程等待通知");
        new Thread(new SingleThread()).start();
        try {
            condition.await(); // 使用await方法来释放资源
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println("主线程恢复运行");

    }

    static class SingleThread implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try {
                condition.signal();// 使用signal来通知唤醒进程！
                System.out.println("子线程通知：");
            }finally {
                lock.unlock();
            }
        }
    }

    static class ThreadDemo implements Runnable{
        Integer id;

        public ThreadDemo(Integer id){
            this.id = id;
        }
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0;i<2;i++){
                lock.lock();
                System.out.println("获得锁的线程："+id);
                lock.unlock();
            }
        }
    }
}
